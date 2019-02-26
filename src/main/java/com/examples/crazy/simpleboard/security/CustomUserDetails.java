package com.examples.crazy.simpleboard.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter @Setter
public class CustomUserDetails extends User {
    // `Spring Security`에서 사용하는 `UserDetails`를 구현하는 클래스 생성
    // `UserDetails`를 직접 구현하지 않고, `UserDetails`를 구현하고 있는 `org.springframework.security.core.userdetails.Member`를 상속받아 구현
    // `UserDetails`는 id(`loginId`로 변경), password, 권한 정보에 대한 기능을 정의
    // 이러한 `UserDetails`를 구현하면서 추가적으로 loginId, `Member`의 ID에 해당하는 값 등을 저장하도록 `CustomUserDetails` 객체를 생성

    private String loginId;
    private Long id;

    public CustomUserDetails(String loginId, String password, Collection<? extends GrantedAuthority> authorities) {
        super(loginId, password, true, true, true, true, authorities);
    }
}
