package com.olympus.platform.repository;

import com.olympus.platform.entity.TypeUserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeUserRepository extends JpaRepository<TypeUserEntity, Long> {

  @Query("SELECT t FROM TypeUserEntity t WHERE t.typeUserId IN (1, 2, 3) ORDER BY t.typeUserId")
  List<TypeUserEntity> findByTypes();
}
