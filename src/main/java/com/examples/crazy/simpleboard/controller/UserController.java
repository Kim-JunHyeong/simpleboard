package com.examples.crazy.simpleboard.controller;

import com.examples.crazy.simpleboard.security.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login(@AuthenticationPrincipal CustomUserDetails userDetails) {
        if (userDetails != null)
            return "redirect:/boards";  // 로그인 상태면 메인페이지로 리다이렉트, JavaScript 로 경고창 설정하자
        return "/user/login";
    }

//    @GetMapping("mypage")
//    public String mypage(@AuthenticationPrincipal) {
//        return "/user/info";
//    }
}
