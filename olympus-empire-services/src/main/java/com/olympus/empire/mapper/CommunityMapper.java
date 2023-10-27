package com.olympus.empire.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import com.olympus.empire.domain.CommunityEntity;
import com.olympus.empire.domain.CommunityManagementEntity;
import com.olympus.empire.domain.CommunityThemeEntity;
import com.olympus.empire.domain.ProfileEntity;
import com.olympus.empire.domain.RoleEntity;
import com.olympus.empire.domain.SubThemeEntity;
import com.olympus.empire.domain.ThemeEntity;
import com.olympus.objects.page.CommunityDTO;

@Mapper
public interface CommunityMapper {
	
	CommunityMapper INSTANCE = Mappers.getMapper(CommunityMapper.class);
	
	@Mapping(target = "communitiesCategories", ignore = true)
	@Mapping(target = "fechaCreacion", ignore = true)
	@Mapping(target = "fechaEdicion", ignore = true)
	@Mapping(target = "status", ignore = true)
	@Mapping(target = "cmScore", ignore = true)
	@Mapping(target = "cmViews", ignore = true)
	CommunityEntity convertCommunityDTO2CommunityEntity (CommunityDTO communityDTO);
	
	@AfterMapping
	default void communityEntityAddDatesAndStatus (@MappingTarget CommunityEntity communityEntity) {
		communityEntity.setFechaCreacion(new Date());
		communityEntity.setFechaEdicion(null);
		communityEntity.setCmScore(new BigDecimal(0));
		communityEntity.setCmViews(0L);
		communityEntity.setStatus(Boolean.TRUE);
	}
	
	default List<CommunityThemeEntity> mappedListCommunitiesAndThemes (CommunityEntity community, 
			List<ThemeEntity> listaTemas, List<SubThemeEntity> listaSubTemas) {
		List<CommunityThemeEntity> listaComunidadesAndTemas = new ArrayList<CommunityThemeEntity>();
		
		for (ThemeEntity tema : listaTemas) {
			for (SubThemeEntity subTema : listaSubTemas) {
				if (subTema.getTheme().getThemeId().equals(tema.getThemeId())) {
					CommunityThemeEntity communityThemeEntity = new CommunityThemeEntity();
					communityThemeEntity.setCommunity(community);
					communityThemeEntity.setFechaCreacion(new Date());
					communityThemeEntity.setFechaEdicion(null);
					communityThemeEntity.setTheme(tema);
					communityThemeEntity.setSubTheme(subTema);
					listaComunidadesAndTemas.add(communityThemeEntity);
				}
			}
		}
		
		return listaComunidadesAndTemas;
	}
	
	default CommunityManagementEntity mappedCommunityManagementForFounder (ProfileEntity profileEntity, RoleEntity roleEntity, CommunityEntity communityEntity) {
		CommunityManagementEntity  communityManagementEntity = new CommunityManagementEntity();
		communityManagementEntity.setCommunity(communityEntity);
		communityManagementEntity.setProfile(profileEntity);
		communityManagementEntity.setRole(roleEntity);
		communityManagementEntity.setFechaCreacion(new Date());
		communityManagementEntity.setFechaEdicion(null);
		return communityManagementEntity;
	}
	
}
