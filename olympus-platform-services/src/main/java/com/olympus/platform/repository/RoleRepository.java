package com.olympus.platform.repository;

import com.olympus.platform.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

  @Query("SELECT r FROM RoleEntity r WHERE r.roleName = :roleName AND r.status = true")
  RoleEntity findByRoleName(String roleName);

  @Query("SELECT r FROM RoleEntity r WHERE r.roleId = :roleId AND r.status = true")
  RoleEntity findByIdAndStatusIsTrue(Long roleId);
}
