package com.olympus.platform.service.impl;

import com.olympus.platform.entity.CountryEntity;
import com.olympus.platform.entity.ProfileEntity;
import com.olympus.platform.entity.ThelephoneEntity;
import com.olympus.platform.entity.UserEntity;
import com.olympus.platform.exception.handler.ResourceConflictsException;
import com.olympus.platform.mapper.ProfileMapper;
import com.olympus.platform.mapper.ThelephoneMapper;
import com.olympus.platform.model.ProfileGetResponseDTO;
import com.olympus.platform.model.ProfilePostRequestDTO;
import com.olympus.platform.model.ProfilePostResponseDTO;
import com.olympus.platform.model.ProfilePutRequestDTO;
import com.olympus.platform.model.ProfilePutResponseDTO;
import com.olympus.platform.model.ThelephoneDTO;
import com.olympus.platform.repository.CountryRepository;
import com.olympus.platform.repository.ProfileRepository;
import com.olympus.platform.repository.TelephoneRepository;
import com.olympus.platform.repository.UserRepository;
import com.olympus.platform.service.ProfileService;
import com.olympus.platform.util.Constants;
import com.olympus.platform.util.UtilValidation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ProfileServiceImpl implements ProfileService {

  @Autowired private UserRepository userRepository;
  @Autowired private ProfileRepository profileRepository;
  @Autowired private CountryRepository countryRepository;
  @Autowired private TelephoneRepository telephoneRepository;

  @Override
  public ProfilePostResponseDTO createProfileService(ProfilePostRequestDTO profilePostRequestDTO) {
    log.info(String.format("createProfileService %s", Constants.START_SERVICE));

    ProfileEntity profileEntity =
        profileRepository.findByNickname(profilePostRequestDTO.getNickname());

    if (profileEntity != null) {
      log.error("This nickname for the profile already exists.");
      throw new ResourceConflictsException(
          String.format(
              "The nickname %s", profilePostRequestDTO.getNickname(), " already exists."));
    }

    UserEntity userEntity =
        userRepository
            .findById(profilePostRequestDTO.getUserId())
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        String.format(
                            "The user with id: %s",
                            profilePostRequestDTO.getUserId(), "%s not found.")));

    CountryEntity countryEntity =
        countryRepository
            .findById(profilePostRequestDTO.getCountryId())
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        String.format(
                            "The country with id: %s",
                            profilePostRequestDTO.getCountryId(), "%s not found.")));

    ProfileEntity profileSaved =
        profileRepository.save(
            ProfileMapper.INSTANCE.mappingProfileEntity(
                profilePostRequestDTO, userEntity, countryEntity));

    profilePostRequestDTO
        .getThelephones()
        .forEach(
            (ThelephoneDTO thelephone) ->
                telephoneRepository.save(
                    ThelephoneMapper.INSTANCE.mappingThelephoneEntity(
                        thelephone,
                        profileSaved,
                        countryRepository
                            .findById(thelephone.getCountryId())
                            .orElseThrow(
                                () ->
                                    new EntityNotFoundException(
                                        String.format(
                                            "The country with id: %s",
                                            thelephone.getCountryId(), "%s not found."))))));

    log.info(String.format("createProfileService %s", Constants.FINAL_SERVICE));
    return ProfilePostResponseDTO.builder()
        .profileId(profileSaved.getProfileId())
        .userId(userEntity.getUserId())
        .creationDate(new Date())
        .build();
  }

  @Override
  public ProfileGetResponseDTO getProfileInformationService(String profileId, String userId) {
    log.info(String.format("getProfileInformationService %s", Constants.START_SERVICE));
    List<ThelephoneDTO> thelephones = new ArrayList<ThelephoneDTO>();

    ProfileEntity profileEntity =
        profileRepository
            .findById(profileId)
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        String.format("The profile with id: %s", profileId, "%s not found.")));

    userRepository
        .findById(userId)
        .orElseThrow(
            () ->
                new EntityNotFoundException(
                    String.format("The user with id: %s", userId, "%s not found.")));

    telephoneRepository
        .findAllByProfileId(profileId)
        .forEach(
            (ThelephoneEntity thelephoneEntity) -> {
              thelephones.add(
                  ThelephoneMapper.INSTANCE.mappingThelephoneDTO(
                      thelephoneEntity,
                      thelephoneEntity.getCountry().getCountryId(),
                      UtilValidation.telInternational(
                          thelephoneEntity.getCountry().getPrefTel(), thelephoneEntity.getNumTel()),
                      thelephoneEntity.getNumTel()));
            });

    log.info(String.format("getProfileInformationService %s", Constants.FINAL_SERVICE));
    return ProfileMapper.INSTANCE.mappingProfileGetResponseDTO(profileEntity, thelephones);
  }

  @Override
  public ProfilePutResponseDTO updateProfileInformationService(
      ProfilePutRequestDTO profilePutRequestDTO) {
    log.info(String.format("updateProfileInformationService %s", Constants.START_SERVICE));

    ProfileEntity profileEntity =
        profileRepository
            .findById(profilePutRequestDTO.getProfileId())
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        String.format(
                            "The profile with id: %s",
                            profilePutRequestDTO.getProfileId(), "%s not found.")));

    UserEntity userEntity =
        userRepository
            .findById(profilePutRequestDTO.getUserId())
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        String.format(
                            "The user with id: %s",
                            profilePutRequestDTO.getUserId(), "%s not found.")));

    CountryEntity countryEntity =
        countryRepository
            .findById(profilePutRequestDTO.getCountryId())
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        String.format(
                            "The country with id: %s",
                            profilePutRequestDTO.getCountryId(), "%s not found.")));

    ProfileEntity profileUpdate =
        profileRepository.save(
            ProfileMapper.INSTANCE.updateMappingProfileEntity(
                profilePutRequestDTO,
                userEntity,
                countryEntity,
                profileEntity.getCreationDate(),
                new Date(),
                profileEntity.getStatus()));

    for (ThelephoneDTO thelephone : profilePutRequestDTO.getThelephones()) {

      Optional<ThelephoneEntity> thelephoneEntity =
          telephoneRepository.findById(thelephone.getTelId());

      if (thelephoneEntity.isEmpty()) {
        telephoneRepository.save(
            ThelephoneMapper.INSTANCE.mappingThelephoneEntity(
                thelephone,
                profileEntity,
                countryRepository.findByPrefTel(thelephone.getPrefTel())));
      } else {
        telephoneRepository.save(
            ThelephoneMapper.INSTANCE.mappingUpdateThelephoneEntity(
                thelephone, thelephoneEntity.get(), profileEntity, new Date(), countryEntity));
      }
    }

    log.info(String.format("updateProfileInformationService %s", Constants.FINAL_SERVICE));
    return ProfilePutResponseDTO.builder()
        .editionDate(profileUpdate.getEditionDate())
        .profileId(profileUpdate.getProfileId())
        .userId(userEntity.getUserId())
        .build();
  }
}
