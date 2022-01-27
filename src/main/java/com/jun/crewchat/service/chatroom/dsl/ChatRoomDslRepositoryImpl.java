package com.jun.crewchat.service.chatroom.dsl;

import com.jun.crewchat.service.chatroom.ChatRoomDTO;
import com.jun.crewchat.service.chatroom.QChatRoom;
import com.jun.crewchat.service.chatroom.QChatRoomEntity;
import com.jun.crewchat.service.chatroomuser.QChatRoomUserEntity;
import com.jun.crewchat.service.friend.FriendDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ChatRoomDslRepositoryImpl extends QuerydslRepositorySupport implements ChatRoomDslRepository {

    private final JPAQueryFactory jpaQueryFactory;
    QChatRoomEntity qChatRoom = QChatRoomEntity.chatRoomEntity;
    QChatRoomUserEntity qChatRoomUser = QChatRoomUserEntity.chatRoomUserEntity;


    public ChatRoomDslRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(QChatRoomEntity.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<ChatRoomDTO> getList(ChatRoomDTO dto) {
        return jpaQueryFactory
                .from(qChatRoom)

                .select(Projections.bean(ChatRoomDTO.class,
                        qChatRoom.roomId
                        , qChatRoom.name
                ))
                .fetch();
    }

    @Override
    public List<ChatRoomDTO> getListWhereMyEmail(ChatRoomDTO dto) {
        return jpaQueryFactory
                .from(qChatRoom)
                .where(
                        qChatRoomUser.userId.eq(dto.getUserId())
                )
                .leftJoin(qChatRoomUser)
                .on(qChatRoomUser.roomId.eq(qChatRoom.roomId))
                .select(Projections.bean(ChatRoomDTO.class,
                        qChatRoom.roomId
                        , qChatRoom.name
                ))
                .fetch();
    }

    @Override
    public ChatRoomDTO roomCheck(ChatRoomDTO dto) {
        return jpaQueryFactory
                .from(qChatRoom)
                .where(
                        qChatRoomUser.userId.eq(dto.getUserId())
                        , qChatRoom.roomId.eq(dto.getRoomId())
                        , qChatRoom.name.eq(dto.getName())
                )
                .leftJoin(qChatRoomUser)
                .on(qChatRoomUser.roomId.eq(qChatRoom.roomId))
                .select(Projections.bean(ChatRoomDTO.class,
                        qChatRoom.roomId
                        , qChatRoom.name
                        , qChatRoomUser.userId
                ))
                .fetchFirst();
    }

    @Override
    public ChatRoomDTO getRoom(ChatRoomDTO dto) {
        return jpaQueryFactory
                .from(qChatRoom)
                .where(
                        qChatRoom.roomId.eq(dto.getRoomId())
                )

                .select(Projections.bean(ChatRoomDTO.class,
                        qChatRoom.roomId
                        , qChatRoom.name
                ))
                .fetchFirst();
    }
}
