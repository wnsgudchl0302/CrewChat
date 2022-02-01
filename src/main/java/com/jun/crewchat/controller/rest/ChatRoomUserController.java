package com.jun.crewchat.controller.rest;

import com.jun.crewchat.service.chatroomuser.ChatRoomUserDTO;
import com.jun.crewchat.service.chatroomuser.ChatRoomUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/chatroomuser")
public class ChatRoomUserController {

    private final ChatRoomUserService chatRoomUserService;

    @PostMapping(value = "/add")
    public void create(ChatRoomUserDTO dto){
        chatRoomUserService.add(dto);
    }
}
