package com.olympus.platform.repository;

import com.olympus.platform.entity.SubThemeEntity;
import com.olympus.platform.entity.ThemeEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubThemeRepository extends JpaRepository<SubThemeEntity, Long> {

  List<SubThemeEntity> findByTheme(ThemeEntity theme);
}
