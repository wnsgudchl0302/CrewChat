package com.jun.crewchat.controller;

import com.jun.crewchat.service.friend.FriendDTO;
import com.jun.crewchat.service.friend.FriendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/friend")
public class FriendController {

    private final FriendService friendService;

    @PostMapping("/getListMyFriend")
    public List<FriendDTO> getListMyFriend(FriendDTO dto){
        return friendService.getListMyFriend(dto);
    }

    @PostMapping("/add")
    public FriendDTO add(FriendDTO dto){
        return friendService.add(dto);
    }
}
