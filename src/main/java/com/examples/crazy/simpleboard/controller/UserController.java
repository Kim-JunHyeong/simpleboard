package com.examples.crazy.simpleboard.controller;

import com.examples.crazy.simpleboard.dto.SignupDto;
import com.examples.crazy.simpleboard.security.CustomUserDetails;
import com.examples.crazy.simpleboard.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(@AuthenticationPrincipal CustomUserDetails userDetails) {
        if (userDetails != null)
            return "redirect:/boards";  // TODO 로그인 상태면 메인페이지로 리다이렉트, JavaScript 로 경고창 설정하자
        return "/user/login";
    }

    @GetMapping("/signup")
    public String signup(ModelMap modelMap,
                         @AuthenticationPrincipal CustomUserDetails userDetails) {
        if (userDetails != null)
            return "redirect:/boards";  // TODO 로그인 상태면 메인페이지로 리다이렉트, JavaScript 로 경고창 설정하자

        modelMap.addAttribute(new SignupDto());
        return "/user/signup";
    }

    @PostMapping("/signup")
    public String signupAction(@Validated @ModelAttribute SignupDto signupDto,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> {
                log.info(error.getDefaultMessage());
            });
            return "user/signup";
        } else {
            userService.saveUser(signupDto);
            return "redirect:/login";
        }
    }

//    @GetMapping("mypage")
//    public String mypage(@AuthenticationPrincipal) {
//        return "/user/info";
//    }
}
