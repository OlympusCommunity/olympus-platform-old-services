package com.olympus.platform.repository;

import com.olympus.platform.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByUserName (String username);

    @Query(
            "SELECT u FROM UserEntity u WHERE u.userName = :userOrEmail OR u.email = :userOrEmail AND u.password = :passwordEncode AND u.status = true")
    Optional<UserEntity> findByUserNameOrEmailAndPassword(String userOrEmail, String passwordEncode);

}
