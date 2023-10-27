package com.olympus.empire.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.olympus.empire.domain.CountryEntity;
import com.olympus.empire.domain.ProfileEntity;
import com.olympus.empire.domain.TelephoneEntity;
import com.olympus.empire.domain.UserEntity;
import com.olympus.empire.mapper.ProfileMapper;
import com.olympus.empire.repository.CountryRepository;
import com.olympus.empire.repository.ProfileRepository;
import com.olympus.empire.repository.TelephoneRepository;
import com.olympus.empire.repository.UserRepository;
import com.olympus.empire.service.ProfileService;
import com.olympus.exception.resource.InternalServerErrorException;
import com.olympus.exception.resource.ResourceConflictException;
import com.olympus.exception.resource.ResourceNotFoundException;
import com.olympus.objects.session.ProfileDTO;
import com.olympus.objects.session.ProfileViewDTO;
import com.olympus.objects.session.TelephoneDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private TelephoneRepository telephoneRepository;

	@Override
	public void guardarPerfil(ProfileDTO profileDTO)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {
		log.info("Inicio del método: guardarPerfil");
		log.info("Atributos(ProfileDTO): " + profileDTO.toString());

		try {
			log.debug("Se busca el usuario especificado con id: " + profileDTO.getUserId());
			UserEntity userEntity =	userRepository.findById(profileDTO.getUserId())
					.orElseThrow(() -> new ResourceNotFoundException("Usuario no registrado en la bd"));
			
			CountryEntity countryProfile = countryRepository.findById(profileDTO.getCountry())
					.orElseThrow(() -> new ResourceNotFoundException("País no registrado en la bd"));
			
			ProfileEntity profileEntitySaved =
					profileRepository.save(
							ProfileMapper.INSTANCE.converProfileDTO2ProfileEntity(profileDTO, userEntity, countryProfile));
			
			log.debug("Se registró correctamente el perfil");
			log.debug("Inicio de registro de números telefónicos");
			
			for (TelephoneDTO telephone : profileDTO.getTelephones()) {
				CountryEntity countryTelephone = countryRepository.findById(telephone.getCountry())
						.orElseThrow(() -> new ResourceNotFoundException("País no registrado en la bd"));

				telephoneRepository
					.save(
							ProfileMapper.INSTANCE
								.convertTelephoneDTOToTelePhoneEntity(telephone, profileEntitySaved, countryTelephone));
			}

			log.info("Se registraron los número de telefono correctamente para el perfil: " + profileEntitySaved.getProfileId());
		} catch (Exception ex) {
			log.error("Error consultando del método: guardarPerfil");
			log.error("Exception: " + ex.getMessage());
			throw new InternalServerErrorException("Error en respuesta del servidor");
		}

	}

	@Override
	public ProfileViewDTO obtenerPerfil(String profileId)
			throws ResourceNotFoundException, InternalServerErrorException {
		log.info("Inicio del método: actualizarPerfil");
		log.info("Atributos(profileId): " + profileId);
		
		ProfileViewDTO profileViewDTO = new ProfileViewDTO();
		
		try {
			log.debug("Se busca el perfil especificado con id: " + profileId);
			ProfileEntity profileEntity = profileRepository.findById(profileId)
					.orElseThrow(() -> new ResourceNotFoundException("Perfil no registrado en la bd"));
			
			List<TelephoneEntity> telephonesEntities = telephoneRepository.findAllByProfileId(profileId);
			
			profileViewDTO = 
					ProfileMapper.INSTANCE.convertProfileEntityToProfileViewDTO(profileEntity, telephonesEntities);
		} catch (Exception ex) {
			log.error("Error consultando del método: obtenerPerfil");
			log.error("Exception: " + ex.getMessage());
			throw new InternalServerErrorException("Error en respuesta del servidor");
		}
		
		return profileViewDTO;
	}

	@Override
	public void actualizarPerfil(String profileId, ProfileDTO profileDTO)
			throws ResourceNotFoundException, ResourceConflictException, InternalServerErrorException {
		log.info("Inicio del método: actualizarPerfil");
		log.info("Atributos(profileId): " + profileId + " (profileDTO): " + profileDTO);
		
		try {
			log.debug("Se busca el perfil especificado con id: " + profileId);
			ProfileEntity profileEntity = profileRepository.findById(profileId)
					.orElseThrow(() -> new ResourceNotFoundException("Perfil no registrado en la bd"));
			
			CountryEntity countryProfile = countryRepository.findById(profileDTO.getCountry())
					.orElseThrow(() -> new ResourceNotFoundException("País no registrado en la bd"));
			
			ProfileEntity profileEntityEdited =
					profileRepository.save(ProfileMapper.INSTANCE.updateMappingProfileEntity(profileEntity, profileDTO, countryProfile));
			
			List<TelephoneEntity> telephonesEntities = telephoneRepository.findAllByProfileId(profileEntityEdited.getProfileId());
			
			for (TelephoneDTO telephone : profileDTO.getTelephones()) {
				for (TelephoneEntity telephoneEntity : telephonesEntities) {
					if (telephoneEntity.getNumTel().equals(telephone.getNumTel())) {
						telephoneRepository.save(
								ProfileMapper.INSTANCE.updateMappingTelephoneEntity(
										telephoneEntity, countryProfile, telephone, profileEntityEdited));
					}
				}
			}
			
		} catch (Exception ex) {
			log.error("Error consultando del método: actualizarPerfil");
			log.error("Exception: " + ex.getMessage());
			throw new InternalServerErrorException("Error en respuesta del servidor");
		}
		
	}

}
