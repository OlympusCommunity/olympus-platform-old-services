package com.olympus.platform.service.impl;

import com.olympus.platform.entity.RoleForUserEntity;
import com.olympus.platform.entity.UserEntity;
import com.olympus.platform.entity.UserRoleEntity;
import com.olympus.platform.repository.RoleForUserRepository;
import com.olympus.platform.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@AllArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleForUserRepository roleForUserRepository;

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with the username " + username));

        List<UserRoleEntity> userRoles = roleForUserRepository.findAllByUserEntity(userEntity).stream().map(RoleForUserEntity::getUserRole).collect(Collectors.toList());

        List<GrantedAuthority> authorities = userRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getUserRoleAlias()))
                .collect(Collectors.toList());
        return new User(userEntity.getUserName(), userEntity.getPassword(), authorities);

    }
}
