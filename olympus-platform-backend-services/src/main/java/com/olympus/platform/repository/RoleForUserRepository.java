package com.olympus.platform.repository;

import com.olympus.platform.entity.RoleForUserEntity;
import com.olympus.platform.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleForUserRepository extends JpaRepository<RoleForUserEntity, Long> {

    @Query("SELECT ru FROM RoleForUserEntity ru WHERE ru.user = :user AND ru.degradedAt IS NOT NULL")
    List<RoleForUserEntity> findAllByUserEntity (UserEntity user);

}
