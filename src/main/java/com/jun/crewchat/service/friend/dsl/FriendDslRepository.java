package com.jun.crewchat.service.friend.dsl;

import com.jun.crewchat.service.friend.FriendDTO;

import java.util.List;

public interface FriendDslRepository {

    List<FriendDTO> isFriend(String myEmail, String friendEmail);
}
