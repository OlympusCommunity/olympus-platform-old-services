package com.olympus.platform.repository;

import com.olympus.platform.entity.WelcomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WelcomeRepository extends JpaRepository<WelcomeEntity, Long> {}
