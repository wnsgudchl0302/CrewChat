package com.jun.crewchat.service.chatroomuser;

import com.jun.crewchat.service.base.GeneratorIDTools;
import com.jun.crewchat.service.chatroom.ChatRoomDTO;
import com.jun.crewchat.service.chatroom.ChatRoomEntity;
import com.jun.crewchat.service.chatroom.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatRoomUserService {

    private final ChatRoomUserRepository chatRoomUserRepository;
    private final ModelMapper modelMapper;

    public void add(ChatRoomUserDTO dto){
        ChatRoomUserEntity chatRoomUserEntity = modelMapper.map(dto, ChatRoomUserEntity.class);
        chatRoomUserEntity.setRoomId(GeneratorIDTools.getId("CR"));
        chatRoomUserRepository.save(chatRoomUserEntity);
    }

}
