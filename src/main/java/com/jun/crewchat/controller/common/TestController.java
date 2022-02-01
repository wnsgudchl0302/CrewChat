package com.jun.crewchat.controller.common;

import com.jun.crewchat.service.chatroom.ChatRoomDTO;
import com.jun.crewchat.service.chatroom.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final ChatRoomService chatRoomRepository;

    @GetMapping("/chat")
    public void getRoom(String roomId, Model model){

        log.info("# get Chat Room, roomID :: " + roomId);

        ChatRoomDTO chatRoomDTO = new ChatRoomDTO();
        chatRoomDTO.setRoomId(roomId);


        model.addAttribute("roomId", roomId);
        model.addAttribute("name", chatRoomRepository.getRoom(chatRoomDTO).getRoomName());
    }
}
