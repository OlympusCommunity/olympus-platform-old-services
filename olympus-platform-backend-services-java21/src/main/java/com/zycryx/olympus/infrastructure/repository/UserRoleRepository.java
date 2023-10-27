package com.zycryx.olympus.infrastructure.repository;

import com.zycryx.olympus.domain.session.UserRoleSession;
import com.zycryx.olympus.domain.session.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleSession, Long> {

    List<UserRoleSession> findAllByUser(UserSession user);

}
