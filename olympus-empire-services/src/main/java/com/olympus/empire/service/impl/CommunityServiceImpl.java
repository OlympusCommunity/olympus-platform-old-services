package com.olympus.empire.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.olympus.empire.domain.CommunityEntity;
import com.olympus.empire.domain.ProfileEntity;
import com.olympus.empire.domain.RoleEntity;
import com.olympus.empire.domain.SubThemeEntity;
import com.olympus.empire.domain.ThemeEntity;
import com.olympus.empire.emun.RoleEnum;
import com.olympus.empire.mapper.CommunityMapper;
import com.olympus.empire.repository.CommunityManagementRepository;
import com.olympus.empire.repository.CommunityRepository;
import com.olympus.empire.repository.CommunityThemeRepository;
import com.olympus.empire.repository.ProfileRepository;
import com.olympus.empire.repository.RoleRepository;
import com.olympus.empire.repository.SubThemeRepository;
import com.olympus.empire.repository.ThemeRepository;
import com.olympus.empire.service.CommunityService;
import com.olympus.empire.util.UtilEncrypting;
import com.olympus.exception.resource.InternalServerErrorException;
import com.olympus.exception.resource.ResourceConflictException;
import com.olympus.exception.resource.ResourceNotFoundException;
import com.olympus.objects.page.CommunityDTO;
import com.olympus.objects.page.CommunityViewDTO;
import com.olympus.objects.page.ThemeCommunityDTO;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CommunityServiceImpl implements CommunityService {
	
	@Autowired
	private CommunityRepository communityRepository;
	@Autowired
	private CommunityManagementRepository communityManagementRepository;
	@Autowired
	private CommunityThemeRepository communityThemeRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private ThemeRepository themeRepository;
	@Autowired
	private SubThemeRepository subThemeRepository;
	
	private void generateCommunityId (ProfileEntity profileEntity, CommunityDTO communityDTO) {
		log.info("Generar Id para la comunidad");
		
		String communityName = 
				UtilEncrypting.base64Encode(communityDTO.getCmName());
		communityDTO.setCmName(communityName);
		communityDTO.setCommunityId(
				communityName.toUpperCase().substring(0, 2) + 
				profileEntity.getProfileId().toUpperCase().substring(0, 2) + 
				profileEntity.getUser().getUserId().toUpperCase().substring(0, 2) +
				RandomStringUtils.randomAlphanumeric(29).toUpperCase());
	}
	
	@Override
	public void guardarComunidadCompleta(CommunityDTO communityDTO, String profileId)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {
		log.info("Inicio del método: guardarComunidadCompleta");
		log.info("Atributos(communityDTO): " + communityDTO.toString());
		
		try {
			
			if (null == communityRepository.findByCmName(communityDTO.getCmName())) {
				
				//Get Profile of founder of the community
				ProfileEntity profileEntity = profileRepository.findById(profileId)
						.orElseThrow(() -> new ResourceNotFoundException("Perfil de Fundador, no registrado en la bd"));
				
				//Get Founder role
				RoleEntity roleFounder = roleRepository.findById(RoleEnum.FOUNDER.getRoleId())
						.orElseThrow(() -> new ResourceNotFoundException("Rol de Fundador, no registrado en la bd"));

				//Get list of id of themes
				List<Long> listaIdsThemes = new ArrayList<>();
				communityDTO.getThemes().forEach((ThemeCommunityDTO tema) -> listaIdsThemes.add(tema.getThemeId()));
				
				//Search all themes for a community
				List<ThemeEntity> themeEntity = themeRepository.findAllById(listaIdsThemes);
				
				//Get list of id of sub-themes
				List<Long> listaIdsSubThemes = new ArrayList<>();
				communityDTO.getThemes().forEach((ThemeCommunityDTO tema) 
						-> listaIdsSubThemes.addAll(
								tema.getSubThemes()));
				
				//Search all subThemes for each theme for a community
				List<SubThemeEntity> listaSubTemas = subThemeRepository.findAllById(listaIdsSubThemes);
				
				//Generate id for Community
				generateCommunityId(profileEntity, communityDTO);

				//Save data only of the community
				CommunityEntity communityEntitySaved = 
						communityRepository.save(CommunityMapper.INSTANCE.convertCommunityDTO2CommunityEntity(communityDTO));
				
				//Save data of the themes and community
				communityThemeRepository
					.saveAll(CommunityMapper.INSTANCE.mappedListCommunitiesAndThemes(communityEntitySaved, themeEntity, listaSubTemas));
				
				//Save data of the Community Management
				communityManagementRepository
					.save(CommunityMapper.INSTANCE.mappedCommunityManagementForFounder(profileEntity, roleFounder, communityEntitySaved));
				
			}
			else {
				log.error("Error, Conflictos al registrar la comunidad");
				throw new ResourceConflictException("La comunidad con el nombre: " + communityDTO.getCmName()
						+ "ya está registrado, Community: " + communityDTO.toString());
			}
			
		} catch (Exception ex) {
			log.error("Error consultando del método: guardarComunidadCompleta");
			log.error("Exception: " + ex.getMessage());
			throw new InternalServerErrorException("Error en respuesta del servidor");
		}
		
	}

	@Override
	public void guardarTematicasAndSubTematicasForComunidad(List<ThemeCommunityDTO> listaTemasPorComunidades)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {
		log.info("Inicio del método: guardarTematicasAndSubTematicasForComunidad");
		log.info("Atributos(ProfileDTO): " + listaTemasPorComunidades.size());
		
		try {
			
			
			
		} catch (Exception ex) {
			log.error("Error consultando del método: guardarTematicasAndSubTematicasForComunidad");
			log.error("Exception: " + ex.getMessage());
			throw new InternalServerErrorException("Error en respuesta del servidor");
		}
	}

	@Override
	public void editarTematicasAndSubTematicasForComunidad(List<ThemeCommunityDTO> listaTemasPorComunidades)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {
		log.info("Inicio del método: editarTematicasAndSubTematicasForComunidad");
		log.info("Atributos(listaTemasPorComunidades): " + listaTemasPorComunidades.size());
		
		try {
			
		} catch (Exception ex) {
			log.error("Error consultando del método: editarTematicasAndSubTematicasForComunidad");
			log.error("Exception: " + ex.getMessage());
			throw new InternalServerErrorException("Error en respuesta del servidor");
		}
	}

	@Override
	public void guardarRolesAtPerfilesForComunidad(List<Long> roles, List<String> profiles)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {
		log.info("Inicio del método: guardarRolesAtPerfilesForComunidad");
		log.info("Atributos(roles): " + roles.size() + " (profiles): " + profiles.size());
		
		try {
			
		} catch (Exception ex) {
			log.error("Error consultando del método: guardarRolesAtPerfilesForComunidad");
			log.error("Exception: " + ex.getMessage());
			throw new InternalServerErrorException("Error en respuesta del servidor");
		}
	}

	@Override
	public void editarRolesAtPerfilesForComunidad(List<Long> roles, List<String> profiles)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {
		log.info("Inicio del método: guardarComunidadCompleta");
		log.info("Atributos(roles): " + roles.size() + " (profiles): " + profiles.size());
		
		try {
			
		} catch (Exception ex) {
			log.error("Error consultando del método: guardarComunidadCompleta");
			log.error("Exception: " + ex.getMessage());
			throw new InternalServerErrorException("Error en respuesta del servidor");
		}
	}

	@Override
	public void editarComunidadCompleta(String communityId, CommunityDTO communityDTO)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {
		log.info("Inicio del método: editarComunidadCompleta");
		log.info("Atributos(ProfileDTO): " + communityDTO.toString() + " (communityId): " + communityId);
		
		try {
			
		} catch (Exception ex) {
			log.error("Error consultando del método: editarComunidadCompleta");
			log.error("Exception: " + ex.getMessage());
			throw new InternalServerErrorException("Error en respuesta del servidor");
		}
	}

	@Override
	public void desaparecerComunidadCompleta(String communityId)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {
		log.info("Inicio del método: desaparecerComunidadCompleta");
		log.info("Atributos(communityId): " + communityId);
		
		try {
			
		} catch (Exception ex) {
			log.error("Error consultando del método: desaparecerComunidadCompleta");
			log.error("Exception: " + ex.getMessage());
			throw new InternalServerErrorException("Error en respuesta del servidor");
		}
	}

	@Override
	public void eliminarComunidadCompleta(String communityId)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {
		log.info("Inicio del método: eliminarComunidadCompleta");
		log.info("Atributos(communityId): " + communityId);
		
		try {
			
		} catch (Exception ex) {
			log.error("Error consultando del método: eliminarComunidadCompleta");
			log.error("Exception: " + ex.getMessage());
			throw new InternalServerErrorException("Error en respuesta del servidor");
		}
	}

	@Override
	public CommunityViewDTO obtenerComunidadCompleta(String communityId)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {
		
		
		log.info("Inicio del método: obtenerComunidadCompleta");
		log.info("Atributos(communityId): " + communityId);
		
		CommunityViewDTO communityViewDTO = new CommunityViewDTO();
		
		try {
			
		} catch (Exception ex) {
			log.error("Error consultando del método: obtenerComunidadCompleta");
			log.error("Exception: " + ex.getMessage());
			throw new InternalServerErrorException("Error en respuesta del servidor");
		}
		
		return communityViewDTO;
	}

}
