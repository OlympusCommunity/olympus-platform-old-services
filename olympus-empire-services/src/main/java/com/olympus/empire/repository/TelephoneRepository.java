package com.olympus.empire.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.olympus.empire.domain.TelephoneEntity;

@Repository
public interface TelephoneRepository extends JpaRepository<TelephoneEntity, Long> {
	
	@Query("SELECT t FROM TelephoneEntity t WHERE t.profile.profileId = :profileId")
	List<TelephoneEntity> findAllByProfileId(String profileId);

}
