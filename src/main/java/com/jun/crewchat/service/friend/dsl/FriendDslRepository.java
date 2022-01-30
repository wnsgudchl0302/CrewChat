package com.jun.crewchat.service.friend.dsl;

import com.jun.crewchat.service.friend.FriendDTO;

import java.util.List;

public interface FriendDslRepository {

    List<FriendDTO> getListMyFriend(FriendDTO dto);
    FriendDTO friendCheck(FriendDTO dto);
}
