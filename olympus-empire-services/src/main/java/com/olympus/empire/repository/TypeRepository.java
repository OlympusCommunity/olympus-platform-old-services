package com.olympus.empire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.olympus.empire.domain.TypeEntity;

@Repository
public interface TypeRepository extends JpaRepository<TypeEntity, Long> {}
