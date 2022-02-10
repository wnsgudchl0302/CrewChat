package com.jun.crewchat.controller.common;

import com.jun.crewchat.security.dto.AuthUserDTO;
import com.jun.crewchat.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class SignUpController {

    private final UserService userService;

    @GetMapping({"/signUp"})
    public String signUp(){
        return userService.signUp();
    }


}
