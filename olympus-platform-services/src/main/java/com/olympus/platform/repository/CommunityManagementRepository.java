package com.olympus.platform.repository;

import com.olympus.platform.entity.CommunityEntity;
import com.olympus.platform.entity.CommunityManagementEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityManagementRepository
    extends JpaRepository<CommunityManagementEntity, Long> {

  List<CommunityManagementEntity> findByCommunity(CommunityEntity community);
}
