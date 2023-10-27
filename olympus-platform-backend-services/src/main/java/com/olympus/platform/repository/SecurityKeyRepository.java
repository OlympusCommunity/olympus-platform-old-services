package com.olympus.platform.repository;

import com.olympus.platform.entity.SecurityKeyEntity;
import com.olympus.platform.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SecurityKeyRepository extends JpaRepository<SecurityKeyEntity, Long> {

    @Query("SELECT MAX(s.codSecurityKey) FROM SecurityKeyEntity s")
    Long findByLastId();

    @Query(
            "SELECT s FROM SecurityKeyEntity s WHERE s.keyPass = :keyPass AND s.ivKey = :ivKey AND s.saltKey = :saltKey")
    SecurityKeyEntity findByKeyPassAndIvKeyAndSaltKey(String keyPass, String ivKey, String saltKey);

    List<SecurityKeyEntity> findByUser(UserEntity user);

    @Query("SELECT s FROM SecurityKeyEntity s WHERE s.user.userName = :credentials OR s.user.email = :credentials")
    Optional<SecurityKeyEntity> findByUserNameOrEmail (String credentials);
}
