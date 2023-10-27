package com.olympus.platform.mapper;

import com.olympus.platform.entity.CountryEntity;
import com.olympus.platform.entity.UserEntity;
import com.olympus.platform.entity.UserRoleEntity;
import com.olympus.platform.model.other.AuditSingInDTO;
import com.olympus.platform.model.session.UserPostRequestDTO;
import com.olympus.platform.model.session.UserPostSigInResponseDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import java.util.Date;
import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(target = "creationDate", ignore = true),
            @Mapping(source = "idGenerated", target = "userId"),
            @Mapping(source = "userDTO.username", target = "userName"),
            @Mapping(source = "userDTO.email", target = "email"),
            @Mapping(source = "userDTO.password", target = "password"),
            @Mapping(source = "userDTO.profileInfo.nickname", target = "nickname"),
            @Mapping(source = "userDTO.profileInfo.name", target = "name"),
            @Mapping(source = "userDTO.profileInfo.surname", target = "surname"),
            @Mapping(source = "userDTO.profileInfo.shortInfo", target = "shortInfo"),
            @Mapping(source = "userDTO.profileInfo.longInfo", target = "longInfo"),
            @Mapping(source = "userDTO.profileInfo.alias", target = "alias"),
            @Mapping(source = "userDTO.profileInfo.birthday", target = "birthday")
    })
    UserEntity mappingCreateUserEntity (UserPostRequestDTO userDTO, CountryEntity country, String idGenerated, List<UserRoleEntity> roles);

}
