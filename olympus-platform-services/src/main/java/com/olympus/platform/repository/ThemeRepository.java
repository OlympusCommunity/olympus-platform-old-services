package com.olympus.platform.repository;

import com.olympus.platform.entity.ThemeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends JpaRepository<ThemeEntity, Long> {

  ThemeEntity findByThemeName(String themeName);
}
