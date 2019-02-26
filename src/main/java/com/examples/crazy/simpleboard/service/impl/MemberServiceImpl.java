package com.examples.crazy.simpleboard.service.impl;

import com.examples.crazy.simpleboard.domain.Member;
import com.examples.crazy.simpleboard.domain.constant.MemberRole;
import com.examples.crazy.simpleboard.dto.SignupDto;
import com.examples.crazy.simpleboard.repository.RoleRepository;
import com.examples.crazy.simpleboard.repository.MemberRepository;
import com.examples.crazy.simpleboard.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public Member getMember(String loginId) {
        return memberRepository.findByLoginId(loginId);
    }

    @Override
    @Transactional
    public Member saveMember(SignupDto signUpDto) {

        Member member = Member.builder()
                .loginId(signUpDto.getLoginId())
                .alias(signUpDto.getAlias())
                .password(passwordEncoder.encode(signUpDto.getPassword()))
                .email(signUpDto.getEmail())
                .roles(roleRepository.findByName(MemberRole.USER))
                .build();

        return memberRepository.save(member);
    }
}
