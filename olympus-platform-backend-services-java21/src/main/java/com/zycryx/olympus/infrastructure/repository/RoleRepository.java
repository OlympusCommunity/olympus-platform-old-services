package com.zycryx.olympus.infrastructure.repository;

import com.zycryx.olympus.domain.session.RoleSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleSession, String> {}
