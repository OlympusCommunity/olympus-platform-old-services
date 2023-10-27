package com.olympus.platform.mapper;

import com.olympus.platform.entity.AuditEntity;
import com.olympus.platform.entity.UserEntity;
import com.olympus.platform.enums.ActionAuditEnum;
import com.olympus.platform.model.audit.AuditRequestDTO;
import com.olympus.platform.model.audit.AuditResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import java.util.Date;

@Mapper
public interface AuditMapper {

    AuditMapper INSTANCE = Mappers.getMapper(AuditMapper.class);

    @Mappings({
            @Mapping(target = "date", source = "date"),
            @Mapping(target = "reason", source = "reason"),
            @Mapping(target = "ipReceiver", source = "ipReceiver"),
            @Mapping(target = "browser", source = "browser"),
            @Mapping(target = "actionDesc", source = "actionDesc"),
            @Mapping(target = "user", source = "user"),
            @Mapping(target = "auditId", ignore = true)
    })
    AuditEntity mappingAuditEntity (UserEntity user, ActionAuditEnum actionDesc, String browser, String ipReceiver, String reason, Date date);

    @Mappings({
            @Mapping(target = "date", source = "date"),
            @Mapping(target = "reason", source = "auditRequestDTO.reason"),
            @Mapping(target = "ipReceiver", source = "auditRequestDTO.ipReceiver"),
            @Mapping(target = "browser", source = "auditRequestDTO.browser"),
            @Mapping(target = "actionDesc", source = "auditRequestDTO.actionDesc"),
            @Mapping(target = "user", source = "user"),
            @Mapping(target = "auditId", ignore = true)
    })
    AuditEntity mappingAuditDTOtoEntity (UserEntity user, AuditRequestDTO auditRequestDTO, Date date);

    @Mappings({
            @Mapping(target = "auditReason", source = "auditEntity.reason"),
            @Mapping(target = "userId", source = "auditEntity.user.userId"),
            @Mapping(target = "auditDate", source = "auditEntity.date")
    })
    AuditResponseDTO mappingAuditResponseDTO (AuditEntity auditEntity);

}
