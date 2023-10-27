package com.olympus.platform.service;

import com.olympus.platform.model.audit.AuditRequestDTO;
import com.olympus.platform.model.audit.AuditResponseDTO;

public interface AuditServiceInterface {

    AuditResponseDTO auditRegisterService (AuditRequestDTO auditRequestDTO);

}
