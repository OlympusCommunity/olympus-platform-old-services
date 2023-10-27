package com.olympus.platform.repository;

import com.olympus.platform.entity.CommunityEntity;
import com.olympus.platform.entity.CommunityThemeEntity;
import com.olympus.platform.entity.ThemeEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityThemeRepository extends JpaRepository<CommunityThemeEntity, Long> {

  List<CommunityThemeEntity> findByTheme(ThemeEntity theme);

  List<CommunityThemeEntity> findByCommunity(CommunityEntity community);
}
