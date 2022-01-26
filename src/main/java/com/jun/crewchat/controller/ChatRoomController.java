package com.jun.crewchat.controller;

import com.jun.crewchat.service.chatroom.ChatRoomDTO;
import com.jun.crewchat.service.chatroom.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/crewchat/chatroom")
public class ChatRoomController {
    private final ChatRoomRepository repository;

    //채팅방 목록 조회
    @PostMapping(value = "/rooms")
    public List<ChatRoomDTO> rooms(){
        return repository.findAllRooms();
    }

    //채팅방 개설
    @PostMapping(value = "/room")
    public ChatRoomDTO create(ChatRoomDTO dto){
        log.info("# Create Chat Room , name: " + dto.getName());
        return repository.createChatRoomDTO(dto.getName());
    }

    //채팅방 조회
    @GetMapping("/room")
    public void getRoom(String roomId, Model model){

        log.info("# get Chat Room, roomID : " + roomId);

        model.addAttribute("room", repository.findRoomById(roomId));
    }
}
