package com.olympus.platform.repository;

import com.olympus.platform.entity.I18nEntity;
import com.olympus.platform.entity.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface I18nRepository extends JpaRepository<I18nEntity, Long> {

    @Query("SELECT i FROM I18nEntity i WHERE i.key = :key AND i.lang.langCodeId = :langCodeId ")
    Optional<I18nEntity> findByKeyAndLangCodeId (String key, String langCodeId);

}
