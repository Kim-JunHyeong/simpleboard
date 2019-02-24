package com.examples.crazy.simpleboard.security;

import com.examples.crazy.simpleboard.domain.Role;
import com.examples.crazy.simpleboard.domain.User;
import com.examples.crazy.simpleboard.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    // `Spring Security`에서 사용하는 `UserDetailsService`를 구현하는 클래스 작성

    private final UserService userService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        User user = userService.getUser(loginId);
        log.info(user.getLoginId());

        if (user == null) {
            throw new UsernameNotFoundException(loginId + "is not found!!");
        }

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }
//        user.getRoles().forEach(role ->
//          ((ArrayList<GrantedAuthority>) authorities).add(new SimpleGrantedAuthority("ROLE_" + role.getName())));

        CustomUserDetails userDetails = new CustomUserDetails(loginId, user.getPassword(), authorities);
        userDetails.setId(user.getId());
        userDetails.setLoginId(user.getLoginId());

        return userDetails;
    }
}

