package com.zycryx.olympus.infrastructure.repository;

import com.zycryx.olympus.domain.session.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserSession, String> {

    Optional<UserSession> findByUsername(String username);

    Optional<UserSession> findByUsernameOrEmailAndPassword(String username, String email, String password);
}
