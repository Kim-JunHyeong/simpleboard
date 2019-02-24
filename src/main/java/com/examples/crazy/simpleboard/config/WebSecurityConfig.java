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
        web.ignoring()
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
                    .defaultSuccessUrl("/boards")
                    .failureUrl("/login");
//                .and()
//                .csrf().ignoringAntMatchers("/**"); // TODO 일단 csrf를 무시하도록 했음. 추후 변경하자
    }
}
