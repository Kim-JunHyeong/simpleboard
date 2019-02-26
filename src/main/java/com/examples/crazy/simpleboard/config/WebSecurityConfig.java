package com.examples.crazy.simpleboard.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }

    // 인증을 무시할 경로
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()//.antMatchers("/static/**", "/**.html");
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                .requestMatchers(new AntPathRequestMatcher("/**.html"))
                .requestMatchers(new AntPathRequestMatcher("/static/**"));
    }

    /*
    http://localhost:8080/logout - 로그아웃처리
    http://localhost:8080/ - 모두 접근 가능
    http://localhost:8080/admin/** - `ADMIN` 권한 사용자만 접근 가능.
    http://localhost:8080/login - 모두 접근 가능
    http://localhost:8080/admin/** - `USER` 권한 사용자만 접근 가능

    GET http://localhost:8080/login - 로그인 화면
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/boards").permitAll().and()
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/admin").hasRole("ADMIN")
                    .antMatchers("/errors/**").permitAll()
                    .antMatchers("/boards/writeform").hasRole("USER")
                    .antMatchers("/boards/**").permitAll()
                    .antMatchers("/login").permitAll()
                    .antMatchers("/signup").permitAll()
                    .antMatchers("/signupForm").permitAll()
                    .antMatchers("/mypage/**").hasRole("USER")
                    .antMatchers("/api/boards").hasRole("USER")
                    .antMatchers("/api/boards/**").permitAll()
                    .anyRequest().fullyAuthenticated().and()
                .formLogin().loginPage("/login")
                    .usernameParameter("loginId").passwordParameter("password")
                    .loginProcessingUrl("/login")
//                    .successForwardUrl("/boards") // 음....내가 커스텀한 login post 폼을 만들 때 사용하는건가??
                    .defaultSuccessUrl("/boards", true) // 왜인지 모르겠지만 true를 사용하지 않으면 자꾸 이미지파일로 리다이렉트됨
                    .failureUrl("/login?loginError=true");
//                .and()
//                .csrf().ignoringAntMatchers("/**"); // th:action 을 사용하면 thymeleaf 가 자동으로 csrf 토큰을 생성해줌
        /**
         * 인증 성공후 어떤 URL로 redirect 할지를 결정한다
         * 판단 기준은 targetUrlParameter 값을 읽은 URL이 존재할 경우 그것을 1순위
         * 1순위 URL이 없을 경우 Spring Security가 세션에 저장한 URL을 2순위
         * 2순위 URL이 없을 경우 Request의 REFERER를 사용하고 그 REFERER URL이 존재할 경우 그 URL을 3순위
         * 3순위 URL이 없을 경우 Default URL을 4순위로 한다
         */
    }
}
