package com.olympus.platform.repository;

import com.olympus.platform.entity.ThelephoneEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TelephoneRepository extends JpaRepository<ThelephoneEntity, Long> {

  @Query("SELECT t FROM ThelephoneEntity t WHERE t.profile.profileId = :profileId")
  List<ThelephoneEntity> findAllByProfileId(String profileId);
}
