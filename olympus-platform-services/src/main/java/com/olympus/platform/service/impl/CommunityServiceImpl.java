package com.olympus.platform.service.impl;

import com.olympus.platform.entity.CommunityEntity;
import com.olympus.platform.entity.CommunityManagementEntity;
import com.olympus.platform.entity.CommunityThemeEntity;
import com.olympus.platform.entity.ProfileEntity;
import com.olympus.platform.entity.ProfileThemeEntity;
import com.olympus.platform.entity.RoleEntity;
import com.olympus.platform.entity.SocialPlatformEntity;
import com.olympus.platform.entity.SubThemeEntity;
import com.olympus.platform.entity.ThemeEntity;
import com.olympus.platform.enums.RoleEnum;
import com.olympus.platform.exception.handler.ResourceConflictsException;
import com.olympus.platform.mapper.CommunityManagementMapper;
import com.olympus.platform.mapper.CommunityMapper;
import com.olympus.platform.mapper.CommunityThemeMapper;
import com.olympus.platform.model.CmPrincipalGetResponseDTO;
import com.olympus.platform.model.CmResumeGetResponseDTO;
import com.olympus.platform.model.CommunityPostRequestDTO;
import com.olympus.platform.model.CommunityPostResponseDTO;
import com.olympus.platform.model.ThemeCommunityDTO;
import com.olympus.platform.repository.CommunityManagementRepository;
import com.olympus.platform.repository.CommunityRepository;
import com.olympus.platform.repository.CommunityThemeRepository;
import com.olympus.platform.repository.ProfileRepository;
import com.olympus.platform.repository.ProfileThemeRepository;
import com.olympus.platform.repository.RoleRepository;
import com.olympus.platform.repository.SocialPlatformRepository;
import com.olympus.platform.repository.SubThemeRepository;
import com.olympus.platform.repository.ThemeRepository;
import com.olympus.platform.service.CommunityService;
import com.olympus.platform.util.Constants;
import com.olympus.platform.util.UtilEncrypting;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class CommunityServiceImpl implements CommunityService {

  @Autowired private CommunityRepository communityRepository;
  @Autowired private ProfileRepository profileRepository;
  @Autowired private ThemeRepository themeRepository;
  @Autowired private SubThemeRepository subThemeRepository;
  @Autowired private RoleRepository roleRepository;
  @Autowired private CommunityThemeRepository communityThemeRepository;
  @Autowired private CommunityManagementRepository communityManagementRepository;
  @Autowired private ProfileThemeRepository profileThemeRepository;
  @Autowired private SocialPlatformRepository socialPlatformRepository;

  private String generateCommunityId(
      ProfileEntity profileEntity, CommunityPostRequestDTO communityPostRequestDTO) {
    return communityPostRequestDTO.getCmName().toUpperCase().substring(0, 2)
        + profileEntity.getProfileId().toUpperCase().substring(0, 2)
        + profileEntity.getUser().getUserId().toUpperCase().substring(0, 2)
        + RandomStringUtils.randomAlphanumeric(29).toUpperCase();
  }

  private String encryptingCommunityName(CommunityPostRequestDTO communityPostRequestDTO) {
    return UtilEncrypting.base64Encode(communityPostRequestDTO.getCmName());
  }

  @Override
  public CommunityPostResponseDTO createCommunityInformationService(
      CommunityPostRequestDTO communityPostRequestDTO, String profileId) {
    log.info(String.format("createCommunityInformationService %s", Constants.START_SERVICE));

    CommunityEntity communityEntity =
        communityRepository.findByCmNameAndStatusIsTrue(communityPostRequestDTO.getCmName());

    if (communityEntity == null) {

      ProfileEntity profileEntity =
          profileRepository
              .findById(profileId)
              .orElseThrow(
                  () ->
                      new EntityNotFoundException(
                          String.format("The profile with id: %s", profileId, "%s not found.")));

      RoleEntity roleEntity =
          roleRepository
              .findById(RoleEnum.FOUNDER.getRoleId())
              .orElseThrow(
                  () ->
                      new EntityNotFoundException(
                          String.format(
                              "The role with id: %s",
                              RoleEnum.FOUNDER.getRoleId(), "%s not found.")));

      List<ThemeEntity> themeList = new ArrayList<ThemeEntity>();
      communityPostRequestDTO
          .getThemes()
          .forEach(
              (ThemeCommunityDTO theme) ->
                  themeList.add(
                      themeRepository
                          .findById(theme.getThemeId())
                          .orElseThrow(
                              () ->
                                  new EntityNotFoundException(
                                      String.format(
                                          "The profile with id: %s",
                                          profileId, "%s not found.")))));

      List<SubThemeEntity> subthemeList = new ArrayList<SubThemeEntity>();
      communityPostRequestDTO
          .getThemes()
          .forEach(
              (ThemeCommunityDTO theme) ->
                  subthemeList.addAll(subThemeRepository.findAllById(theme.getSubThemes())));

      CommunityEntity communitySaved =
          communityRepository.save(
              CommunityMapper.INSTANCE.mappingCommunityEntity(
                  communityPostRequestDTO,
                  generateCommunityId(profileEntity, communityPostRequestDTO),
                  encryptingCommunityName(communityPostRequestDTO)));

      themeList.forEach(
          (ThemeEntity theme) -> {
            subthemeList.forEach(
                (SubThemeEntity subTheme) -> {
                  if (subTheme.getTheme().getThemeId().equals(theme.getThemeId())) {
                    communityThemeRepository.save(
                        CommunityThemeMapper.INSTANCE.mappingCommunityThemeEntity(
                            communitySaved, theme, subTheme));
                  }
                });
          });

      communityManagementRepository.save(
          CommunityManagementMapper.INSTANCE.mappingCommunityManagement(
              profileEntity, roleEntity, communitySaved));

      log.info(String.format("createCommunityInformationService %s", Constants.FINAL_SERVICE));
      return CommunityPostResponseDTO.builder()
          .communityId(communitySaved.getCommunityId())
          .creationDate(new Date())
          .build();

    } else {
      log.error("This name for the community already exists.");
      throw new ResourceConflictsException(
          String.format("The name %s", communityPostRequestDTO.getCmName(), " already exists."));
    }
  }

  @Override
  public List<CmPrincipalGetResponseDTO> getCommunitiesForPrincipalPageService(String profileId) {
    log.info(String.format("createCommunityInformationService %s", Constants.START_SERVICE));

    List<ProfileThemeEntity> profileThemeList =
        profileThemeRepository.findByProfileEntityId(profileId);
    List<CmPrincipalGetResponseDTO> communitiesForProfile =
        new ArrayList<CmPrincipalGetResponseDTO>();

    if (profileThemeList.isEmpty() || profileThemeList == null) {
      log.debug(String.format("Communities recomended not found for profileId: %s", profileId));
      return communitiesForProfile;
    } else {

      List<CommunityEntity> communityForProfileRecomendedList = new ArrayList<CommunityEntity>();
      profileThemeList.forEach(
          (ProfileThemeEntity profileThemes) -> {
            ThemeEntity themeForProfile =
                themeRepository
                    .findById(profileThemes.getTheme().getThemeId())
                    .orElseThrow(
                        () ->
                            new EntityNotFoundException(
                                String.format(
                                    "The profile with id: %s", profileId, "%s not found.")));

            List<CommunityThemeEntity> communityForProfileList =
                communityThemeRepository.findByTheme(themeForProfile);

            communityForProfileList.forEach(
                (CommunityThemeEntity cmTheme) -> {
                  communityForProfileRecomendedList.add(
                      communityRepository.findById(cmTheme.getCommunity().getCommunityId()).get());
                });
          });

      List<CommunityEntity> communityDistinctList =
          communityForProfileRecomendedList.stream().distinct().collect(Collectors.toList());

      communityDistinctList.forEach(
          (CommunityEntity communityDistinct) -> {
            List<CommunityThemeEntity> communityThemeList =
                communityThemeRepository.findByCommunity(communityDistinct);
            List<CommunityManagementEntity> communityManagerList =
                communityManagementRepository.findByCommunity(communityDistinct);
            List<SocialPlatformEntity> socialPlatformList =
                socialPlatformRepository.findByCommunity(communityDistinct);

            CmPrincipalGetResponseDTO cmPrincipalGetResponseDTO =
                CommunityMapper.INSTANCE.mappingCmPrincipalGetResponseDTO(
                    communityDistinct,
                    communityThemeList,
                    communityManagerList,
                    socialPlatformList);

            CommunityMapper.INSTANCE.addDataCommunityForProfile(
                cmPrincipalGetResponseDTO,
                communityThemeList,
                communityManagerList,
                socialPlatformList);

            communitiesForProfile.add(cmPrincipalGetResponseDTO);
          });
    }
    return communitiesForProfile;
  }

  @Override
  public List<CmResumeGetResponseDTO> getCommunities(String proifleId, String userId) {
    log.info(String.format("getCommunities %s", Constants.START_SERVICE));
    List<CmResumeGetResponseDTO> communities = new ArrayList<CmResumeGetResponseDTO>();

    if (proifleId.isBlank()) {
      profileRepository.findByIdAndStatusIsTrue(proifleId);
    } else {

    }

    log.info(String.format("getCommunities %s", Constants.FINAL_SERVICE));
    return communities;
  }
}
