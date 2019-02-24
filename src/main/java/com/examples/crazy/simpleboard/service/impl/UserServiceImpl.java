package com.examples.crazy.simpleboard.service.impl;

import com.examples.crazy.simpleboard.domain.User;
import com.examples.crazy.simpleboard.domain.constant.RoleName;
import com.examples.crazy.simpleboard.dto.SignupDto;
import com.examples.crazy.simpleboard.repository.RoleRepository;
import com.examples.crazy.simpleboard.repository.UserRepository;
import com.examples.crazy.simpleboard.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public User getUser(String loginId) {
        return userRepository.findByLoginId(loginId);
    }

    @Override
    @Transactional
    public User saveUser(SignupDto signUpDto) {

        User user = User.builder()
                .loginId(signUpDto.getLoginId())
                .alias(signUpDto.getAlias())
                .password(passwordEncoder.encode(signUpDto.getPassword()))
                .email(signUpDto.getEmail())
                .roles(roleRepository.findByName(RoleName.USER.name()))
                .build();

        return userRepository.save(user);
    }
}
