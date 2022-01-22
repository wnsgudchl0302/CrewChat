package com.jun.crewchat.controller;

import com.jun.crewchat.security.dto.AuthUserDTO;
import com.jun.crewchat.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/crewchat")
public class SignInController {

    private final UserService userService;

    @GetMapping({"","/"})
    public String sign(){
        return userService.sign();
    }
    @GetMapping({ "/sign"})
    public String signIn(@AuthenticationPrincipal AuthUserDTO authUserDTO) {
        return userService.signIn(authUserDTO);
    }


}
