package com.examples.crazy.simpleboard.controller;

import com.examples.crazy.simpleboard.dto.SignupDto;
import com.examples.crazy.simpleboard.security.CustomUserDetails;
import com.examples.crazy.simpleboard.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String login(@AuthenticationPrincipal CustomUserDetails userDetails,
                        @RequestParam(defaultValue = "false") String loginError,
                        ModelMap modelMap) {
        if (userDetails != null)
            return "redirect:/boards";  // TODO 로그인 상태면 메인페이지로 리다이렉트, JavaScript 로 경고창 설정하자
        modelMap.addAttribute("loginError", loginError);
        return "member/login";
    }

    @GetMapping("/signup")
    public String signup(ModelMap modelMap,
                         @AuthenticationPrincipal CustomUserDetails userDetails) {
        if (userDetails != null)
            return "redirect:/boards";  // TODO 로그인 상태면 메인페이지로 리다이렉트, JavaScript 로 경고창 설정하자

        modelMap.addAttribute(new SignupDto());
        return "member/signup";
    }

    @PostMapping("/signup")
    public String signupAction(@Validated @ModelAttribute SignupDto signupDto,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> {
                log.info(error.getDefaultMessage());
            });
            return "member/signup";
        } else {
            memberService.saveMember(signupDto);
            return "redirect:/login";
        }
    }

//    @GetMapping("mypage")
//    public String mypage(@AuthenticationPrincipal) {
//        return "/member/info";
//    }
}
