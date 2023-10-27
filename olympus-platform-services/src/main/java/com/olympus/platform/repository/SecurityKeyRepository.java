package com.olympus.platform.repository;

import com.olympus.platform.entity.SecurityKeysEntity;
import com.olympus.platform.entity.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityKeyRepository extends JpaRepository<SecurityKeysEntity, Long> {

  @Query("SELECT MAX(s.codSecurityKey) FROM SecurityKeysEntity s")
  Long findByLastId();

  @Query(
      "SELECT s FROM SecurityKeysEntity s WHERE keyPass = :keyPass AND ivKey = :ivKey AND saltKey = :saltKey")
  SecurityKeysEntity findByKeyPassAndIvKeyAndSaltKey(String keyPass, String ivKey, String saltKey);

  List<SecurityKeysEntity> findByUser(UserEntity user);
}
