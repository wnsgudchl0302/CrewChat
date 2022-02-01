package com.jun.crewchat.service.chatroomuser;

import com.jun.crewchat.service.base.DefaultEntity;
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
public class ChatRoomUser extends DefaultEntity {

    @Id
    protected String chatRoomUserId;

    protected String roomId;

    protected String email;
}
