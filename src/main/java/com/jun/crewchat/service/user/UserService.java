package com.jun.crewchat.service.user;

import com.jun.crewchat.security.dto.AuthUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    public String signIn(AuthUserDTO authUserDTO) {
        return authUserDTO != null ? "main.html" : "sign.html";
    }

    public String signUp(UserDTO userDTO) {
        log.info("UserDTO \n"+userDTO);
        System.out.println(userDTO);
        return "redirect:/crewchat";
    }
}
