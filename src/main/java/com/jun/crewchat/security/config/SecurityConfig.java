package com.jun.crewchat.security.config;

import com.jun.crewchat.define.EUrl;
import com.jun.crewchat.define.EUserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Slf4j
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        String contextPath = EUrl.DEFAULT_URL.getUrl();

        http.headers().frameOptions().sameOrigin();
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers(contextPath+"/sign").permitAll()
                .antMatchers(contextPath).hasRole(EUserRole.USER.name())
                .antMatchers("/chat/rooms").hasRole(EUserRole.USER.name())
                .antMatchers("/chat/room").hasRole(EUserRole.USER.name())
            .and()
                .formLogin()
                .loginPage(contextPath+"/sign")
                .defaultSuccessUrl(contextPath)
                .failureUrl(contextPath+"/sign")
            .and()
                .logout()
                .logoutSuccessUrl(contextPath+"/sign")
                .invalidateHttpSession(true)
            .and()
                .oauth2Login()// 로그인 시에 OAuth 를 사용한 로그인이 가능하도록
                .loginPage(contextPath+"/sign")
                .failureUrl(contextPath) // 인가/인증에 문제시 로그인 화면으로 이동
                .defaultSuccessUrl(contextPath, true);
    }
}
