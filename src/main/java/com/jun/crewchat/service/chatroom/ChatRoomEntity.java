package com.jun.crewchat.service.chatroom;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "chat_room")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class ChatRoomEntity extends ChatRoom{
}
