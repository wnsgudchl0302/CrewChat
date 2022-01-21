package com.jun.crewchat.controller;

import com.jun.crewchat.security.dto.AuthUserDTO;
import com.jun.crewchat.service.user.UserDTO;
import com.jun.crewchat.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/crewchat")
public class SignController {

    private final UserService userService;

    @GetMapping({"", "/"})
    public String test(@AuthenticationPrincipal AuthUserDTO authUserDTO) {
        return userService.signIn(authUserDTO);
    }

    @PostMapping("/sign-up")
    public String signUp(UserDTO userDTO) {
        return userService.signUp(userDTO);
    }
}
