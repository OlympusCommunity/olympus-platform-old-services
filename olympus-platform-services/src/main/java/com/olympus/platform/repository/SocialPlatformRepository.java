package com.olympus.platform.repository;

import com.olympus.platform.entity.CommunityEntity;
import com.olympus.platform.entity.SocialPlatformEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialPlatformRepository extends JpaRepository<SocialPlatformEntity, Long> {

  List<SocialPlatformEntity> findByCommunity(CommunityEntity community);
}
