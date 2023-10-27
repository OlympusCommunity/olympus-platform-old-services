package com.olympus.platform.repository;

import com.olympus.platform.entity.CommunityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends JpaRepository<CommunityEntity, String> {

  @Query(
      "SELECT cm FROM CommunityEntity cm WHERE cm.communityId = :communityId AND cm.status = true")
  CommunityEntity findByIdAndStatusIsTrue(String communityId);

  @Query("SELECT cm FROM CommunityEntity cm WHERE cm.cmName = :cmName AND cm.status = true")
  CommunityEntity findByCmNameAndStatusIsTrue(String cmName);
}
