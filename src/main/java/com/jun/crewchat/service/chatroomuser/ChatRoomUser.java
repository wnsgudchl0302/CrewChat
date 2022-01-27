package com.jun.crewchat.service.chatroomuser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@SuperBuilder
public class ChatRoomUser {

    @Id
    protected String chatRoomUserId;

    protected String roomId;

    protected String userId;
}
