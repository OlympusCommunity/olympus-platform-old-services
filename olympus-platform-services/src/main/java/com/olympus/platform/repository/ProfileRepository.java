package com.olympus.platform.repository;

import com.olympus.platform.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, String> {

  @Query("SELECT p FROM ProfileEntity p WHERE p.nickname = :nickname AND p.status = true")
  ProfileEntity findByNickname(String nickname);

  @Query("SELECT p FROM ProfileEntity p WHERE p.profileId = :profileId AND p.status = true")
  ProfileEntity findByIdAndStatusIsTrue(String profileId);
}
