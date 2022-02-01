package com.jun.crewchat.service.friend;

import com.jun.crewchat.service.base.GeneratorIDTools;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FriendService {

    private final FriendRepository friendRepository;
    private final ModelMapper modelMapper;

    public List<FriendDTO> getListMyFriend(FriendDTO dto) {
        return friendRepository.getListMyFriend(dto);
    }

    public void delete(FriendDTO dto) {
        FriendDTO friendDTO = friendRepository.friendCheck(dto);

        if(friendDTO != null){
            friendRepository.deleteById(friendDTO.getFriendId());
        }
    }


}
