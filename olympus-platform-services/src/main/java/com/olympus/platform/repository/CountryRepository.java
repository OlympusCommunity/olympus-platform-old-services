package com.olympus.platform.repository;

import com.olympus.platform.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {

  CountryEntity findByPrefTel(String prefTel);
}
