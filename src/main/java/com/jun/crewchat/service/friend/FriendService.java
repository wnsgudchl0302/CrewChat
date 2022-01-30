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

    public FriendDTO add(FriendDTO dto) {
        if(friendCheck(dto)){
            FriendEntity friendEntity = modelMapper.map(dto, FriendEntity.class);
            friendEntity.setFriendId(GeneratorIDTools.getId("F"));
            return modelMapper.map(friendRepository.save(friendEntity), FriendDTO.class);
        }
        return new FriendDTO();
    }

    private boolean friendCheck(FriendDTO dto){

        if(friendRepository.friendCheck(dto)==null){
            log.info(dto.getFriendId());
            return true;
        }
        log.info(dto.getFriendId());
        return false;
    }
}
