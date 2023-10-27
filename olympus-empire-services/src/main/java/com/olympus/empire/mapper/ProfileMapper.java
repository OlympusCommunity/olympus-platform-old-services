package com.olympus.empire.mapper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.olympus.empire.domain.CountryEntity;
import com.olympus.empire.domain.ProfileEntity;
import com.olympus.empire.domain.TelephoneEntity;
import com.olympus.empire.domain.UserEntity;
import com.olympus.empire.util.Constantes;
import com.olympus.empire.util.DateUtils;
import com.olympus.objects.session.ProfileDTO;
import com.olympus.objects.session.ProfileViewDTO;
import com.olympus.objects.session.TelephoneDTO;
import com.olympus.objects.session.TypeUserViewDTO;
import com.olympus.objects.session.UserViewDTO;

@Mapper
public interface ProfileMapper {
	
	ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

	default ProfileEntity converProfileDTO2ProfileEntity (ProfileDTO profileDTO, UserEntity userEntity, CountryEntity countryEntity) throws ParseException {
		ProfileEntity profileEntity = new ProfileEntity();
		profileEntity.setProfileId(userEntity.getUserId());
		profileEntity.setAlias(profileDTO.getAlias());
		profileEntity.setNickname(profileDTO.getNickname());
		profileEntity.setBirthday(DateUtils.convertStringToDate(profileDTO.getBirthday()));
		profileEntity.setCity(profileDTO.getCity());
		profileEntity.setCountry(countryEntity);
		profileEntity.setFechaCreacion(new Date());
		profileEntity.setFechaEdicion(null);
		profileEntity.setInfo(profileDTO.getInfo());
		profileEntity.setName(profileDTO.getName());
		profileEntity.setProfileId(
				Constantes.PROFILE_ABV + userEntity.getUserId());
		profileEntity.setStatus(Boolean.TRUE);
		profileEntity.setSurname(profileDTO.getSurname());
		profileEntity.setUser(userEntity);
		return profileEntity;
	}
	
	default ProfileEntity updateMappingProfileEntity (ProfileEntity profileEntity, ProfileDTO profileDTO, CountryEntity countryEntity) throws ParseException {
		profileEntity.setAlias(profileDTO.getAlias());
		profileEntity.setBirthday(DateUtils.convertStringToDate(profileDTO.getBirthday()));
		profileEntity.setCity(profileDTO.getCity());
		profileEntity.setCountry(countryEntity);
		profileEntity.setFechaCreacion(profileEntity.getFechaCreacion());
		profileEntity.setFechaEdicion(new Date());
		profileEntity.setNickname(profileDTO.getNickname());
		profileEntity.setInfo(profileDTO.getInfo());
		profileEntity.setName(profileDTO.getName());
		profileEntity.setStatus(Boolean.TRUE);
		profileEntity.setSurname(profileDTO.getSurname());
		profileEntity.setProfileId(profileEntity.getProfileId());
		return profileEntity;
	}
	
	default TelephoneEntity updateMappingTelephoneEntity (
			TelephoneEntity telephoneEntity, CountryEntity countryEntity, TelephoneDTO telephone, ProfileEntity profileEntity) {
		telephoneEntity.setCountry(countryEntity);
		telephoneEntity.setFechaCreacion(telephoneEntity.getFechaCreacion());
		telephoneEntity.setNumTel(telephone.getNumTel());
		telephoneEntity.setProfile(profileEntity);
		telephoneEntity.setStatus(telephoneEntity.getStatus());
		telephoneEntity.setTelId(telephoneEntity.getTelId());
		telephoneEntity.setFechaEdicion(new Date());
		return telephoneEntity;
	}

	default ProfileViewDTO convertProfileEntityToProfileViewDTO (
			ProfileEntity profileEntity, List<TelephoneEntity> telephonesEntities) {
		ProfileViewDTO profileViewDTO = new ProfileViewDTO();
		profileViewDTO.setAlias(profileEntity.getAlias());
		profileViewDTO.setUpdateAt(DateUtils.convertDateToString(profileEntity.getFechaEdicion()));
		profileViewDTO.setCreateAt(DateUtils.convertDateToString(profileEntity.getFechaCreacion()));
		profileViewDTO.setCity(profileEntity.getCity());
		profileViewDTO.setCountry(profileEntity.getCountry().getCountryName());
		profileViewDTO.setInfo(profileEntity.getInfo());
		profileViewDTO.setName(profileEntity.getName());
		profileViewDTO.setSurname(profileEntity.getSurname());
		profileViewDTO.setNickname(profileEntity.getNickname());
		profileViewDTO.setBirthday(DateUtils.convertDateToString(profileEntity.getBirthday()));
		
		UserViewDTO userViewDTO = new UserViewDTO();
		userViewDTO.setUserId(profileEntity.getUser().getUserId());
		userViewDTO.setUsername(profileEntity.getUser().getUsername());
		userViewDTO.setEmail(profileEntity.getUser().getEmail());
		
		TypeUserViewDTO typeUserViewDTO = new TypeUserViewDTO();
		typeUserViewDTO.setName(profileEntity.getUser().getTypeEntity().getName());
		typeUserViewDTO.setAlias(profileEntity.getUser().getTypeEntity().getAlias());
		
		userViewDTO.setTypeUser(typeUserViewDTO);
		
		profileViewDTO.setUser(userViewDTO);
		
		List<TelephoneDTO> listaTelefonos = new ArrayList<>();
		for (TelephoneEntity telephone : telephonesEntities) {
			TelephoneDTO telephoneDTO = new TelephoneDTO();
			telephoneDTO.setCountry(telephone.getCountry().getCountryId());
			telephoneDTO.setCountryName(telephone.getCountry().getCountryName());
			telephoneDTO.setNumPrefAndTel(telephone.getCountry().getPrefTel() + " " + telephone.getNumTel());
			telephoneDTO.setNumTel(telephone.getNumTel());
			listaTelefonos.add(telephoneDTO);
		}
		
		profileViewDTO.setTelephones(listaTelefonos);
		
		return profileViewDTO;
	}
	
	default TelephoneEntity convertTelephoneDTOToTelePhoneEntity (TelephoneDTO telephoneDTO, ProfileEntity profileEntity, CountryEntity countryEntity) {
		TelephoneEntity telephoneEntity = new TelephoneEntity();
		telephoneEntity.setCountry(countryEntity);
		telephoneEntity.setFechaCreacion(new Date());
		telephoneEntity.setFechaEdicion(null);
		telephoneEntity.setNumTel(telephoneDTO.getNumTel());
		telephoneEntity.setProfile(profileEntity);
		telephoneEntity.setStatus(Boolean.TRUE);
		return telephoneEntity;
	}
}
