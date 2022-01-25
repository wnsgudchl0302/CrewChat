package com.jun.crewchat.service.friend;

import com.jun.crewchat.service.base.GeneratorIDTools;
import com.jun.crewchat.service.friendpost.FriendPostDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FriendService {

    private final FriendRepository friendRepository;

    @EventListener
    public void addFriend(FriendPostDTO dto) {
        if (friendRepository.isFriend(dto.getSender(), dto.getReceiver()).size() == 0) {
            save(dto.getSender(), dto.getReceiver());
            save(dto.getReceiver(), dto.getSender());
        }
    }

    private void save(String firstEmail, String secondEmail){
        friendRepository.save(
                FriendEntity.builder()
                        .friendId(GeneratorIDTools.getId("F"))
                        .myEmail(firstEmail)
                        .friendEmail(secondEmail)
                        .build()
        );
    }
}
