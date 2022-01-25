package com.jun.crewchat.controller;

import com.jun.crewchat.service.friendpost.FriendPostDTO;
import com.jun.crewchat.service.friendpost.FriendPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/crewchat/friendPost")
public class FriendPostController {

    private final FriendPostService friendPostService;

    @PostMapping("/requestFriend")
    public void requestFriend(FriendPostDTO dto){
        friendPostService.requestFriend(dto);
    }

    @PostMapping("/acceptFriend")
    public void acceptFriend(FriendPostDTO dto){
        friendPostService.acceptFriend(dto);
    }
}
