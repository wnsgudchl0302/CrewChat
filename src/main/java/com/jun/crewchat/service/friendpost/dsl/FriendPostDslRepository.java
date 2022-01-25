package com.jun.crewchat.service.friendpost.dsl;

import com.jun.crewchat.service.friendpost.FriendPostDTO;

public interface FriendPostDslRepository {

    FriendPostDTO isRequesting(String sender, String receiver);
    FriendPostDTO isRequestingOnlyMe(String sender, String receiver);
}
