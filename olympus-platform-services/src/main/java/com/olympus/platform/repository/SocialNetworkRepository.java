package com.olympus.platform.repository;

import com.olympus.platform.entity.SocialNetworkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialNetworkRepository extends JpaRepository<SocialNetworkEntity, Long> {}
