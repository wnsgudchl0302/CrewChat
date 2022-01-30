package com.jun.crewchat.service.chatroom;

import com.jun.crewchat.service.chatroom.dsl.ChatRoomDslRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, String>, ChatRoomDslRepository {

}
