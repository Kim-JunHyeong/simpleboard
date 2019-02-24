package com.examples.crazy.simpleboard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SignupDto {

    private String loginId;
    private String password;
    private String passwordCheck;
    private String alias;
    private String email;
}
