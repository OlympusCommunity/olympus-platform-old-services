package com.olympus.empire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.olympus.empire.domain.ProfileEntity;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, String>{}
