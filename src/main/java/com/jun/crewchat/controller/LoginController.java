package com.jun.crewchat.controller;

import com.jun.crewchat.security.dto.AuthUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/crewchat")
public class LoginController {

    @GetMapping({"","/"})
    public String test(@AuthenticationPrincipal AuthUserDTO authUserDTO){
        if(authUserDTO != null){
            log.info("로그인 성공");
            return "main.html";
        }else{
            log.info("로그인 실패");
            return "sign.html";
        }
    }
}
