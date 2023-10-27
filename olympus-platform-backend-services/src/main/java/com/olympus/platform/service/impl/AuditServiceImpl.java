package com.olympus.platform.service.impl;

import com.olympus.platform.constants.ValidationConstant;
import com.olympus.platform.entity.AuditEntity;
import com.olympus.platform.entity.UserEntity;
import com.olympus.platform.mapper.AuditMapper;
import com.olympus.platform.model.audit.AuditRequestDTO;
import com.olympus.platform.model.audit.AuditResponseDTO;
import com.olympus.platform.repository.AuditRepository;
import com.olympus.platform.repository.UserRepository;
import com.olympus.platform.service.AuditServiceInterface;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

@Service
@Log4j2
@AllArgsConstructor
public class AuditServiceImpl implements AuditServiceInterface {

    private final AuditRepository auditRepository;
    private final UserRepository userRepository;

    /**
     * @param auditRequestDTO
     * @return
     */
    @Override
    public AuditResponseDTO auditRegisterService(AuditRequestDTO auditRequestDTO) {
        log.info("auditRegisterService");
        UserEntity user = userRepository.findById(auditRequestDTO.getUserId()).orElseThrow(() -> new EntityNotFoundException(ValidationConstant.USER_NOT_FOUND));
        AuditEntity auditEntity = auditRepository.save(AuditMapper.INSTANCE.mappingAuditDTOtoEntity(user, auditRequestDTO, new Date()));
        return AuditMapper.INSTANCE.mappingAuditResponseDTO(auditEntity);
    }
}
