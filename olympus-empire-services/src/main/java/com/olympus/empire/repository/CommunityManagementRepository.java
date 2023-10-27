package com.olympus.empire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olympus.empire.domain.CommunityManagementEntity;

@Repository
public interface CommunityManagementRepository extends JpaRepository<CommunityManagementEntity, Long> {

}
