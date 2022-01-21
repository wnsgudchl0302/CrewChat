package com.jun.crewchat.service.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends User {

    private String passwordConfirm;
}
