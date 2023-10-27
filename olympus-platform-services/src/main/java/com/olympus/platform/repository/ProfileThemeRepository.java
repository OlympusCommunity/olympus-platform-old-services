package com.olympus.platform.repository;

import com.olympus.platform.entity.ProfileThemeEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileThemeRepository extends JpaRepository<ProfileThemeEntity, Long> {

  @Query("SELECT pt FROM ProfileThemeEntity pt WHERE pt.profile.profileId = :profileId")
  List<ProfileThemeEntity> findByProfileEntityId(String profileId);
}
