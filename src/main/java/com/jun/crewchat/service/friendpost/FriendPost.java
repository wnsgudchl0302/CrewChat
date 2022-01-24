package com.jun.crewchat.service.friendpost;

import com.jun.crewchat.service.base.DTOKey;
import com.jun.crewchat.service.base.DefaultEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class FriendPost extends DefaultEntity {

    @Id
    @DTOKey("FPI")
    protected String friendPostId;

    @Column(nullable = false)
    protected String sender;

    @Column(nullable = false)
    protected String receiver;

    protected String requestType;
}
