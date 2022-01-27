package com.jun.crewchat.service.chatroom;

import com.jun.crewchat.service.base.GeneratorIDTools;
import com.jun.crewchat.service.chatroomuser.ChatRoomUserEntity;
import com.jun.crewchat.service.chatroomuser.ChatRoomUserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomUserRepository chatRoomUserRepository;
    private final ModelMapper modelMapper;


    public List<ChatRoomDTO> getList(ChatRoomDTO dto){
        return chatRoomRepository.getList(dto);
    }
    public List<ChatRoomDTO> getListWhereMyEmail(ChatRoomDTO dto){
        return chatRoomRepository.getListWhereMyEmail(dto);
    }

    public ChatRoomDTO roomCheck(ChatRoomDTO dto){
        return chatRoomRepository.roomCheck(dto);
    }
    public ChatRoomDTO getRoom(ChatRoomDTO dto){
        return chatRoomRepository.getRoom(dto);
    }

    public ChatRoomDTO add(ChatRoomDTO dto){
        ChatRoomEntity chatRoomEntity = modelMapper.map(dto, ChatRoomEntity.class);
        chatRoomEntity.setRoomId(GeneratorIDTools.getId("CR"));
        chatRoomEntity = chatRoomRepository.save(chatRoomEntity);
        ChatRoomUserEntity chatRoomUserEntity = ChatRoomUserEntity.builder()
                .chatRoomUserId(GeneratorIDTools.getId("CHU"))
                .roomId(chatRoomEntity.getRoomId())
                .email("ambirion0302@gmail.com")
                .build();
        chatRoomUserRepository.save(chatRoomUserEntity);
        return modelMapper.map(chatRoomEntity, ChatRoomDTO.class);
    }


}
