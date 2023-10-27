package com.olympus.empire.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.olympus.empire.domain.SubThemeEntity;
import com.olympus.empire.domain.ThemeEntity;

@Repository
public interface SubThemeRepository extends JpaRepository<SubThemeEntity, Long> {
	
	List<SubThemeEntity> findByTheme(ThemeEntity theme);
	

}
