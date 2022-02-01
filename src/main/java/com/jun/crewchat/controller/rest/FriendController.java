package com.jun.crewchat.controller.rest;

import com.jun.crewchat.biz.FriendBizService;
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
    private final FriendBizService friendBizService;

    @PostMapping("/getListMyFriend")
    public List<FriendDTO> getListMyFriend(FriendDTO dto){
        return friendService.getListMyFriend(dto);
    }

    @PostMapping("/add")
    public FriendDTO add(FriendDTO dto){
        return friendBizService.add(dto);
    }

    @PostMapping("/delete")
    public void delete(FriendDTO dto){
        friendService.delete(dto);
    }
}
