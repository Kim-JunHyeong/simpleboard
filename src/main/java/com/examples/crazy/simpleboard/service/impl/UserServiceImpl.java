package com.examples.crazy.simpleboard.service.impl;

import com.examples.crazy.simpleboard.domain.User;
import com.examples.crazy.simpleboard.repository.UserRepository;
import com.examples.crazy.simpleboard.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public User getUser(String loginId) {
        return userRepository.findByLoginId(loginId);
    }
}
