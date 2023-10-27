package com.olympus.empire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.olympus.empire.domain.CommunityThemeEntity;

@Repository
public interface CommunityThemeRepository extends JpaRepository<CommunityThemeEntity, Long> {

}
