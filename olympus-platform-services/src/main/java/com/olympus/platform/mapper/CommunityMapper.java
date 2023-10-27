package com.olympus.platform.mapper;

import com.olympus.platform.entity.CommunityEntity;
import com.olympus.platform.entity.CommunityManagementEntity;
import com.olympus.platform.entity.CommunityThemeEntity;
import com.olympus.platform.entity.ProfileEntity;
import com.olympus.platform.entity.SocialPlatformEntity;
import com.olympus.platform.enums.RoleEnum;
import com.olympus.platform.model.CmMemberProfileDTO;
import com.olympus.platform.model.CmPrincipalGetResponseDTO;
import com.olympus.platform.model.CommunityPostRequestDTO;
import com.olympus.platform.model.SocialNetworkCommunityDTO;
import com.olympus.platform.model.SocialPtCommunityDTO;
import com.olympus.platform.model.ThemeCommunityDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommunityMapper {

  CommunityMapper INSTANCE = Mappers.getMapper(CommunityMapper.class);

  @Mappings({
    @Mapping(target = "cmPhoto", ignore = true),
    @Mapping(source = "cmName", target = "cmName"),
    @Mapping(target = "cmScore", ignore = true),
    @Mapping(target = "cmViews", ignore = true),
    @Mapping(target = "communitiesCategories", ignore = true),
    @Mapping(target = "creationDate", ignore = true),
    @Mapping(target = "deleteDate", ignore = true),
    @Mapping(target = "editionDate", ignore = true),
    @Mapping(target = "status", ignore = true)
  })
  public CommunityEntity mappingCommunityEntity(
      CommunityPostRequestDTO communityPostRequestDTO, String communityId, String cmName);

  @AfterMapping
  public default void addDefaultDataForCommunity(@MappingTarget CommunityEntity communityEntity) {
    communityEntity.setCreationDate(new Date());
    communityEntity.setStatus(Boolean.TRUE);
  }

  @Mappings({
    @Mapping(target = "founder", ignore = true),
    @Mapping(target = "numberOfTotalMembers", ignore = true),
    @Mapping(target = "socialPlatforms", ignore = true),
    @Mapping(target = "themes", ignore = true)
  })
  public CmPrincipalGetResponseDTO mappingCmPrincipalGetResponseDTO(
      CommunityEntity communityEntity,
      List<CommunityThemeEntity> communityThemeList,
      List<CommunityManagementEntity> communityManagerList,
      List<SocialPlatformEntity> socialPlatformList);

  @AfterMapping
  public default void addDataCommunityForProfile(
      @MappingTarget CmPrincipalGetResponseDTO cmPrincipalGetResponseDTO,
      List<CommunityThemeEntity> communityThemeList,
      List<CommunityManagementEntity> communityManagerList,
      List<SocialPlatformEntity> socialPlatformList) {
    List<ProfileEntity> profiles = new ArrayList<ProfileEntity>();
    communityManagerList.forEach(
        (CommunityManagementEntity cm) -> {
          if (cm.getRole().getRoleId().equals(RoleEnum.FOUNDER.getRoleId())) {
            CmMemberProfileDTO founderForCommunity = new CmMemberProfileDTO();
            founderForCommunity.setProfileId(cm.getProfile().getProfileId());
            founderForCommunity.setPhoto(cm.getProfile().getProfilePhoto());
            founderForCommunity.setName(cm.getProfile().getName());
            founderForCommunity.setAlias(cm.getProfile().getAlias());
            founderForCommunity.setSurname(cm.getProfile().getSurname());
            founderForCommunity.setRoleName(cm.getRole().getRoleName());
            founderForCommunity.setNickname(cm.getProfile().getNickname());
            profiles.add(cm.getProfile());
            cmPrincipalGetResponseDTO.setFounder(founderForCommunity);
          }
        });

    List<ThemeCommunityDTO> themeForCommunityList = new ArrayList<ThemeCommunityDTO>();
    communityThemeList.forEach(
        (CommunityThemeEntity ct) -> {
          ThemeCommunityDTO themeCommunityDTO = new ThemeCommunityDTO();
          themeCommunityDTO.setThemeId(ct.getTheme().getThemeId());
          themeCommunityDTO.setThemeName(ct.getTheme().getThemeName());
          themeForCommunityList.add(themeCommunityDTO);
        });
    cmPrincipalGetResponseDTO.setThemes(
        themeForCommunityList.stream().distinct().collect(Collectors.toList()));

    List<SocialPtCommunityDTO> socialPtForCommunityList = new ArrayList<SocialPtCommunityDTO>();
    socialPlatformList.forEach(
        (SocialPlatformEntity pt) -> {
          SocialPtCommunityDTO socialPtForCommunity = new SocialPtCommunityDTO();
          SocialNetworkCommunityDTO socialNetworkForCommunity = new SocialNetworkCommunityDTO();
          socialNetworkForCommunity.setSocialId(pt.getSocialNetwork().getSocialId());
          socialNetworkForCommunity.setSocialName(pt.getSocialNetwork().getSocialName());
          socialPtForCommunity.setSocialNetwork(socialNetworkForCommunity);
          socialPtForCommunity.setSocialPtId(pt.getSocialPtId());
          socialPtForCommunity.setSocialPtLink(pt.getSocialPtLink());
          socialPtForCommunity.setSocialPtView(pt.getSocialPtView());
          socialPtForCommunityList.add(socialPtForCommunity);
        });
    cmPrincipalGetResponseDTO.setSocialPlatforms(socialPtForCommunityList);

    cmPrincipalGetResponseDTO.setNumberOfTotalMembers(profiles.stream().distinct().count());
  }
}
