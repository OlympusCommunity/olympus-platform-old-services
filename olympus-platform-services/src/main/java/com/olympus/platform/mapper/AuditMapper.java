package com.olympus.platform.mapper;

import com.olympus.platform.entity.ActionAuditEntity;
import com.olympus.platform.entity.AuditEntity;
import com.olympus.platform.entity.UserEntity;
import com.olympus.platform.model.AuditDTO;
import java.util.Date;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuditMapper {

  AuditMapper INSTANCE = Mappers.getMapper(AuditMapper.class);

  @Mappings({
    @Mapping(target = "auditId", ignore = true),
    @Mapping(target = "date", ignore = true),
    @Mapping(target = "action", source = "actionAuditEntity")
  })
  public AuditEntity mappingBinnacleEntityWithParameters(
      UserEntity user,
      String ipReceiver,
      String reason,
      ActionAuditEntity actionAuditEntity,
      String browser);

  @AfterMapping
  public default void addDataToBinnacleEntityWithParameters(
      @MappingTarget AuditEntity auditEntity) {
    auditEntity.setDate(new Date());
  }

  @Mapping(source = "user.userId", target = "userId")
  public AuditDTO mappingBinnacleDTO(AuditEntity auditEntity);

  @AfterMapping
  public default void addLoginDateToBinnacleDTO(@MappingTarget AuditDTO auditDTO) {
    auditDTO.setDate(new Date());
  }
}
