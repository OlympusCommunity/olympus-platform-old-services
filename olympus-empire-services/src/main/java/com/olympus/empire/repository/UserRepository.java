package com.olympus.empire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.olympus.empire.domain.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

	@Query("SELECT u FROM UserEntity u WHERE u.username = :username")
	UserEntity findByUsername(String username);

	@Query("SELECT u FROM UserEntity u WHERE u.username = :userOrEmail OR u.email = :userOrEmail AND u.password = :passwordEncode")
	UserEntity findByUsernameOrEmailAndPassword(String userOrEmail, String passwordEncode);

}
