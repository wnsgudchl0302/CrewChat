package com.jun.crewchat.controller;

import com.jun.crewchat.service.user.UserDTO;
import com.jun.crewchat.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
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
}
