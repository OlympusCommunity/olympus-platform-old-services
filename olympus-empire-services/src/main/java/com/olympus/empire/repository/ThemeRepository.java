package com.olympus.empire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olympus.empire.domain.ThemeEntity;

@Repository
public interface ThemeRepository extends JpaRepository<ThemeEntity, Long> {
	
	ThemeEntity findByThemeDesc(String themeDesc);

}
