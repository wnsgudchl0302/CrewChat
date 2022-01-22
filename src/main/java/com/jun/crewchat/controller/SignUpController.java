package com.jun.crewchat.controller;

import com.jun.crewchat.service.user.UserDTO;
import com.jun.crewchat.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/crewchat")
public class SignUpController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public String signUp(@RequestBody @Validated UserDTO userDTO, BindingResult bindingResult) {
       return userService.signUp(userDTO, bindingResult);
    }

    @PostMapping("/kakao-login")
    public void kakao() {

    }
}
