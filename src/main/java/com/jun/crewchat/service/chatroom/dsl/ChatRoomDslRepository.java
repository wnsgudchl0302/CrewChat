package com.jun.crewchat.service.chatroom.dsl;

import com.jun.crewchat.service.chatroom.ChatRoomDTO;

import java.util.List;

public interface ChatRoomDslRepository {
    List<ChatRoomDTO> getList(ChatRoomDTO dto);
    List<ChatRoomDTO> getListWhereMyEmail(ChatRoomDTO dto);
    ChatRoomDTO roomCheck(ChatRoomDTO dto);
    ChatRoomDTO getRoom(ChatRoomDTO dto);
}
