package com.olympus.empire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.olympus.empire.domain.CommunityEntity;

@Repository
public interface CommunityRepository extends JpaRepository<CommunityEntity, String> {
	
	CommunityEntity findByCmName(String cmName);

}
