package com.jun.crewchat.security.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String contextPath = "/crewchat";
        http.csrf().disable();

        http.formLogin()
                .loginPage(contextPath + "/sign-in") //로그인 Url
                .defaultSuccessUrl(contextPath, true)
                .failureUrl(contextPath) // 인가/인증에 문제시 로그인 화면으로 이동
                .and()
                .logout()
                .logoutSuccessUrl(contextPath)
                .invalidateHttpSession(true);
        http.oauth2Login();
    }
}
