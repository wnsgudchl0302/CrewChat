package com.jun.crewchat.biz;

import com.jun.crewchat.service.base.GeneratorIDTools;
import com.jun.crewchat.service.friend.FriendDTO;
import com.jun.crewchat.service.friend.FriendEntity;
import com.jun.crewchat.service.friend.FriendRepository;
import com.jun.crewchat.service.friend.FriendService;
import com.jun.crewchat.service.user.UserDTO;
import com.jun.crewchat.service.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FriendBizService {

    private final FriendRepository friendRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public FriendDTO add(FriendDTO dto) {
        if(friendCheck(dto)){
            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(dto.getFriendEmail());;

            FriendEntity friendEntity = modelMapper.map(dto, FriendEntity.class);
            friendEntity.setFriendId(GeneratorIDTools.getId("F"));
            dto = modelMapper.map(friendRepository.save(friendEntity), FriendDTO.class);
            dto.setName(userRepository.getMyInfo(userDTO).getName());
            return dto;
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
