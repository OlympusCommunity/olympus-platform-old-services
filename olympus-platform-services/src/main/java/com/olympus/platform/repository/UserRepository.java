package com.olympus.platform.repository;

import com.olympus.platform.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

  UserEntity findByUsername(String username);

  @Query(
      "SELECT u FROM UserEntity u WHERE u.username = :userOrEmail OR u.email = :userOrEmail AND u.password = :passwordEncode AND u.status = true")
  UserEntity findByUsernameOrEmailAndPassword(String userOrEmail, String passwordEncode);

  @Query(
      "SELECT u FROM UserEntity u WHERE u.username = :userOrEmail OR u.email = :userOrEmail AND u.status = true")
  UserEntity findByUsernameOrEmail(String userOrEmail);
}
