package com.jun.crewchat.controller.rest;

import com.jun.crewchat.biz.ChatRoomBizService;
import com.jun.crewchat.service.chatroom.ChatRoomDTO;
import com.jun.crewchat.service.chatroom.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/chatroom")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;
    private final ChatRoomBizService chatRoomBizService;

    //채팅방 목록 조회
    @PostMapping(value = "/getList")
    public List<ChatRoomDTO> rooms(ChatRoomDTO dto){
        return chatRoomService.getList(dto);
    }

    @PostMapping(value = "/getListWhereMyEmail")
    public List<ChatRoomDTO> getListWhereMyEmail(ChatRoomDTO dto){
        log.info(dto.getEmail());
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
        log.info("# Create Chat Room , name: " + dto.getRoomName());
        return chatRoomService.add(dto);
    }
    @PostMapping(value = "/chatMyFriend")
    public String chatMyFriend(ChatRoomDTO dto){
        return chatRoomBizService.chatMyFriend(dto);
    }

}
