package com.jun.crewchat.service.friendpost;

import com.jun.crewchat.define.EFriendPostRequestType;
import com.jun.crewchat.service.base.GeneratorIDTools;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FriendPostService {

    private final FriendPostRepository friendPostRepository;
    private final ModelMapper modelMapper;
    private final ApplicationEventPublisher publisher;

    /*
     * 친구 요청
     */
    public void requestFriend(FriendPostDTO dto) {
        if (friendPostRepository.isRequesting(dto.sender, dto.receiver) == null) {
            FriendPostEntity entity = modelMapper.map(dto, FriendPostEntity.class);
            entity.setFriendPostId(GeneratorIDTools.getId("FP"));
            entity.setRequestType(EFriendPostRequestType.ING.name());
            friendPostRepository.save(entity);
        }
    }

    /*
     * 친구 수락
     */
    public void acceptFriend(FriendPostDTO dto){
        FriendPostDTO friendPostDTO = friendPostRepository.isRequestingOnlyMe(dto.sender, dto.receiver);
        if (friendPostDTO != null) {
            FriendPostEntity entity = modelMapper.map(dto, FriendPostEntity.class);
            entity.setFriendPostId(friendPostDTO.getFriendPostId());
            entity.setRequestType(EFriendPostRequestType.COMPLETE.name());
            friendPostRepository.save(entity);
            publisher.publishEvent(dto);
        }
    }
}
