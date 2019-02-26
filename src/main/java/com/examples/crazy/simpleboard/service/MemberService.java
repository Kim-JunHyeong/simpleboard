package com.examples.crazy.simpleboard.service;

import com.examples.crazy.simpleboard.domain.Member;
import com.examples.crazy.simpleboard.dto.SignupDto;

public interface MemberService {

    Member getMember(String loginId);

    Member saveMember(SignupDto signUpDto);
}
