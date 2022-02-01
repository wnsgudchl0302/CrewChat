package com.jun.crewchat.controller.rest;

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

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/getMyInfo")
    public UserDTO getMyInfo(UserDTO dto) {
        return userService.getMyInfo(dto);
    }

    @PostMapping("/getList")
    public List<UserDTO> getList(UserDTO dto) {
        return userService.getList(dto);
    }

    @PostMapping("/sign-up")
    public String signUp(@RequestBody @Validated UserDTO userDTO, BindingResult bindingResult) {
        return userService.signUp(userDTO, bindingResult);
    }
}
