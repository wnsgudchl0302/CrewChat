package com.jun.crewchat.service.friend;

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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Friend extends DefaultEntity {

    @Id @DTOKey("FI")
    protected String friendId;

    @Column(nullable = false)
    protected String myEmail;

    @Column(nullable = false)
    protected String friendEmail;

}
