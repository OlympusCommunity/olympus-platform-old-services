package com.olympus.empire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.olympus.empire.domain.SecurityKeysEntity;

@Repository
public interface SecurityKeyRepository extends JpaRepository<SecurityKeysEntity, Long> {
	
	@Query("SELECT MAX(s.codSecurityKey) FROM SecurityKeysEntity s")
	Long findByLastId ();
	
	@Query("SELECT s FROM SecurityKeysEntity s WHERE keyPass = :keyPass AND ivKey = :ivKey AND saltKey = :saltKey")
	SecurityKeysEntity findByKeyPassAndIvKeyAndSaltKey (String keyPass, String ivKey, String saltKey);
	
}