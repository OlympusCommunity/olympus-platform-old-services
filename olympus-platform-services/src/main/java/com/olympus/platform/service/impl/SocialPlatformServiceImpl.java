package com.olympus.platform.service.impl;

import com.olympus.platform.entity.CommunityEntity;
import com.olympus.platform.entity.SocialNetworkEntity;
import com.olympus.platform.entity.SocialPlatformEntity;
import com.olympus.platform.mapper.SocialPlatformMapper;
import com.olympus.platform.model.SocialPtPostRequestDTO;
import com.olympus.platform.model.SocialPtPostResponseDTO;
import com.olympus.platform.repository.CommunityRepository;
import com.olympus.platform.repository.SocialNetworkRepository;
import com.olympus.platform.repository.SocialPlatformRepository;
import com.olympus.platform.service.SocialPaltformService;
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
public class SocialPlatformServiceImpl implements SocialPaltformService {

  @Autowired private CommunityRepository communityRepository;
  @Autowired private SocialNetworkRepository socialNetworkRepository;
  @Autowired private SocialPlatformRepository socialPlatformRepository;

  @Override
  public SocialPtPostResponseDTO createSocialPlatformToCommunity(
      List<SocialPtPostRequestDTO> socialRequestList, String profileId) {
    log.info(String.format("createSocialPlatformToCommunity %s", Constants.START_SERVICE));

    List<SocialPlatformEntity> socialPlatformEntityList = new ArrayList<SocialPlatformEntity>();
    socialRequestList.forEach(
        (SocialPtPostRequestDTO socialPlatform) -> {
          CommunityEntity communityEntity =
              communityRepository
                  .findById(socialPlatform.getCommunityId())
                  .orElseThrow(
                      () ->
                          new EntityNotFoundException(
                              String.format(
                                  "Community not found with id: %s",
                                  socialPlatform.getCommunityId())));

          SocialNetworkEntity socialNetworkEntity =
              socialNetworkRepository
                  .findById(socialPlatform.getSocialId())
                  .orElseThrow(
                      () ->
                          new EntityNotFoundException(
                              String.format(
                                  "Social Network not found with id: %s",
                                  socialPlatform.getSocialId())));

          socialPlatformEntityList.add(
              socialPlatformRepository.save(
                  SocialPlatformMapper.INSTANCE.mappingSocialPaltformEntity(
                      socialPlatform, communityEntity, socialNetworkEntity)));
        });

    List<Long> socialPtEntityIdList = new ArrayList<Long>();
    socialPlatformEntityList.forEach(
        (SocialPlatformEntity socialPlatformSaved) -> {
          socialPtEntityIdList.add(socialPlatformSaved.getSocialPtId());
        });

    log.info(String.format("createSocialPlatformToCommunity %s", Constants.FINAL_SERVICE));
    return SocialPtPostResponseDTO.builder()
        .fechaCreacion(new Date())
        .socialPtId(socialPtEntityIdList)
        .profileId(profileId)
        .build();
  }
}
