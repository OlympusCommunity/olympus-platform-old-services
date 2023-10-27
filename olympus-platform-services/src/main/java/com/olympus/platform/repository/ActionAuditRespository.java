package com.olympus.platform.repository;

import com.olympus.platform.entity.ActionAuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionAuditRespository extends JpaRepository<ActionAuditEntity, Long> {}
