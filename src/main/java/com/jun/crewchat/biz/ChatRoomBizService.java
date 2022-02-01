package com.jun.crewchat.biz;

import com.jun.crewchat.service.base.GeneratorIDTools;
import com.jun.crewchat.service.chatroom.ChatRoomDTO;
import com.jun.crewchat.service.chatroom.ChatRoomEntity;
import com.jun.crewchat.service.chatroom.ChatRoomRepository;
import com.jun.crewchat.service.chatroomuser.ChatRoomUserEntity;
import com.jun.crewchat.service.chatroomuser.ChatRoomUserRepository;
import com.jun.crewchat.service.friend.FriendDTO;
import com.jun.crewchat.service.friend.FriendRepository;
import com.jun.crewchat.service.user.User;
import com.jun.crewchat.service.user.UserDTO;
import com.jun.crewchat.service.user.UserEntity;
import com.jun.crewchat.service.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatRoomBizService {

    private final UserRepository userRepository;
    private final FriendRepository friendRepository;
    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomUserRepository chatRoomUserRepository;

    public String chatMyFriend(ChatRoomDTO dto) {
        List<String> chatRoomIdList = chatRoomRepository.getListRoomCheck(dto.getEmail(), dto.getFriendEmail())
                .stream()
                .map(ChatRoomDTO::getRoomId)
                .collect(Collectors.toList());
        Set<String> roomId = new HashSet<>();
        for (String chatRoomId : chatRoomIdList) {
            if (chatRoomIdList.indexOf(chatRoomId) != chatRoomIdList.lastIndexOf(chatRoomId)) {
                roomId.add(chatRoomId);
            }
        }
        FriendDTO friendDTO = FriendDTO.builder()
                .myEmail(dto.getEmail())
                .friendEmail(dto.getFriendEmail())
                .build();
        if (friendRepository.friendCheck(friendDTO) != null && roomId.size() == 0) {
            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(dto.getFriendEmail());

            ChatRoomEntity chatRoomEntity = ChatRoomEntity.builder()
                    .roomId(GeneratorIDTools.getId("CR"))
                    .roomName(userRepository.getMyInfo(userDTO).getName())
                    .isGroup(false)
                    .build();
            ChatRoomEntity entity = chatRoomRepository.save(chatRoomEntity);
            ChatRoomUserEntity chatRoomUserMyEntity = ChatRoomUserEntity.builder()
                    .chatRoomUserId(GeneratorIDTools.getId("CRU"))
                    .roomId(entity.getRoomId())
                    .email(dto.getEmail())
                    .build();
            ChatRoomUserEntity chatRoomUserFriendEntity = ChatRoomUserEntity.builder()
                    .chatRoomUserId(GeneratorIDTools.getId("CRU"))
                    .roomId(entity.getRoomId())
                    .email(dto.getFriendEmail())
                    .build();
            chatRoomUserRepository.save(chatRoomUserMyEntity);
            chatRoomUserRepository.save(chatRoomUserFriendEntity);
            return entity.getRoomId();
        }
        Iterator<String> rId = roomId.iterator();
        return rId.next();
    }
}
