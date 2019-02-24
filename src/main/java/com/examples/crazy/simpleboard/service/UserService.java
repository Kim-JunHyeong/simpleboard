package com.examples.crazy.simpleboard.service;

import com.examples.crazy.simpleboard.domain.User;
import com.examples.crazy.simpleboard.dto.SignupDto;

public interface UserService {

    User getUser(String loginId);

    User saveUser(SignupDto signUpDto);
}
