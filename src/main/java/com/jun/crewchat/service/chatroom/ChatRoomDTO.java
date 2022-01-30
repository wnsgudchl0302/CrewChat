package com.jun.crewchat.service.chatroom;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class ChatRoomDTO extends ChatRoom {

    private String email;
}
