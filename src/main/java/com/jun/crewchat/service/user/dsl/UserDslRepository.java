package com.jun.crewchat.service.user.dsl;

import com.jun.crewchat.service.user.UserDTO;

import java.util.List;

public interface UserDslRepository {

    List<UserDTO> getList(UserDTO dto);
    UserDTO getMyInfo(UserDTO dto);
}
