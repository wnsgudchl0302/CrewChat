package com.jun.crewchat.controller;

import com.jun.crewchat.service.chatroom.ChatRoomDTO;
import com.jun.crewchat.service.chatroom.ChatRoomEntity;
import com.jun.crewchat.service.chatroom.ChatRoomRepository;
import com.jun.crewchat.service.chatroom.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
@Slf4j
public class TestController {

    private final ChatRoomService chatRoomRepository;

    @GetMapping("/roomw")
    public void getRoom(String roomId, Model model){

        log.info("# get Chat Room, roomID : " + roomId);

        ChatRoomDTO chatRoomDTO = new ChatRoomDTO();
        chatRoomDTO.setRoomId(roomId);


        model.addAttribute("roomId", roomId);
        model.addAttribute("name", chatRoomRepository.getRoom(chatRoomDTO).getName());
    }
}