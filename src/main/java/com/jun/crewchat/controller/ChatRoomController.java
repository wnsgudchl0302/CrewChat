package com.jun.crewchat.controller;

import com.jun.crewchat.service.chatroom.ChatRoomDTO;
import com.jun.crewchat.service.chatroom.ChatRoomRepository;
import com.jun.crewchat.service.chatroom.ChatRoomService;
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
    private final ChatRoomService chatRoomService;


    //채팅방 목록 조회
    @PostMapping(value = "/getList")
    public List<ChatRoomDTO> rooms(ChatRoomDTO dto){
        return chatRoomService.getList(dto);
    }

    @PostMapping(value = "/getListWhereMyEmail")
    public List<ChatRoomDTO> getListWhereMyEmail(ChatRoomDTO dto){
        return chatRoomService.getListWhereMyEmail(dto);
    }

    @PostMapping(value = "/roomCheck")
    public ChatRoomDTO roomCheck(ChatRoomDTO dto){
        return chatRoomService.roomCheck(dto);
    }

    @PostMapping(value = "/getRoom")
    public ChatRoomDTO getRoom(ChatRoomDTO dto){
        return chatRoomService.getRoom(dto);
    }

    //채팅방 개설
    @PostMapping(value = "/add")
    public ChatRoomDTO add(ChatRoomDTO dto){
        log.info("# Create Chat Room , name: " + dto.getName());
        return chatRoomService.add(dto);
    }
//
//    @PostMapping(value = "/join")
//    public ChatRoomDTO join(ChatRoomDTO dto){
//        log.info("# Create Chat Room , name: " + dto.getName());
//        return chatRoomService.join(dto);
//    }

    //채팅방 조회
//    @GetMapping("/room")
//    public void getRoom(String roomId, Model model){
//
//        log.info("# get Chat Room, roomID : " + roomId);
//
//        model.addAttribute("room", chatRoomService.findRoomById(roomId));
//    }
//    @PostMapping("/roomIn")
//    public ChatRoomDTO getRoom(ChatRoomDTO dto){
//
//        log.info("# get Chat Room, roomID : " + dto.getRoomId());
//
//        return chatRoomService.findRoomById(dto.getRoomId());
//    }
}
