package com.olympus.platform.service.impl;

import com.olympus.platform.entity.ProfileEntity;
import com.olympus.platform.entity.SubThemeEntity;
import com.olympus.platform.mapper.ProfileThemeMapper;
import com.olympus.platform.model.ProfileThemePostRequestDTO;
import com.olympus.platform.model.ProfileThemePostResponseDTO;
import com.olympus.platform.model.ThemeCommunityDTO;
import com.olympus.platform.repository.ProfileRepository;
import com.olympus.platform.repository.ProfileThemeRepository;
import com.olympus.platform.repository.SubThemeRepository;
import com.olympus.platform.service.ProfileThemeService;
import com.olympus.platform.util.Constants;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ProfileThemeServiceImpl implements ProfileThemeService {

  @Autowired private SubThemeRepository subThemeRepository;
  @Autowired private ProfileThemeRepository profileThemeRepository;
  @Autowired private ProfileRepository profileRepository;

  @Override
  public ProfileThemePostResponseDTO createThemesForProfileService(
      ProfileThemePostRequestDTO profileThemePostRequestDTO, String profileId) {
    log.info(String.format("createThemesForProfileService %s", Constants.START_SERVICE));
    List<Long> profileForThemes = new ArrayList<Long>();
    List<SubThemeEntity> subthemeList = new ArrayList<SubThemeEntity>();

    ProfileEntity profileEntity =
        profileRepository
            .findById(profileId)
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        String.format("The profile with id: %s", profileId, "%s not found.")));

    profileThemePostRequestDTO
        .getThemesForProfile()
        .forEach(
            (ThemeCommunityDTO theme) -> {
              List<Long> subthemeIdList = new ArrayList<Long>();
              theme.getSubThemes().forEach(st -> subthemeIdList.add(st));
              subthemeList.addAll(subThemeRepository.findAllById(subthemeIdList));
            });

    subthemeList.forEach(
        (SubThemeEntity st) -> {
          profileForThemes.add(
              profileThemeRepository
                  .save(
                      ProfileThemeMapper.INSTANCE.mappingProfileThemeEntity(
                          profileEntity, st.getTheme(), st))
                  .getProfileThemeId());
        });

    log.info(String.format("createThemesForProfileService %s", Constants.FINAL_SERVICE));
    return ProfileThemePostResponseDTO.builder()
        .creationDate(new Date())
        .profileThemeIdList(profileForThemes)
        .build();
  }
}
