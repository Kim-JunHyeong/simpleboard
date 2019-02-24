package com.examples.crazy.simpleboard.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter
public class SignupDto {

    @NotBlank(message = "아이디를 입력하지 않았습니다.")
    @Size(min = 4, max = 20, message = "아이디는 4글자 이상 20글자 이하로 입력해주세요.")
    private String loginId;

    @NotBlank(message = "비밀번호를 입력하지 않았습니다.")
    @Size(min = 4, message = "비밀번호는 4글자 이상 입력해주세요.")
    private String password;

    @NotBlank(message = "비밀번호를 입력하지 않았습니다.")
    private String passwordCheck;

    @NotBlank(message = "닉네임을 입력하지 않았습니다.")
    @Size(min = 2, max = 20, message = "닉네임은 2글자 이상 20글자 이하로 입력해주세요.")
    private String alias;

    @NotBlank(message = "이메일 주소를 입력하지 않았습니다.")
    @Email(message = "양식이 올바르지 않습니다.")
    private String email;

    public boolean isEqualPassword() {
        if (this.password.equals(this.passwordCheck))
            return true;
        else
            return false;
    }
}
