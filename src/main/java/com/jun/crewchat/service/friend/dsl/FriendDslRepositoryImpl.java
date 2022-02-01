package com.jun.crewchat.service.friend.dsl;

import com.jun.crewchat.service.friend.FriendDTO;
import com.jun.crewchat.service.friend.QFriendEntity;
import com.jun.crewchat.service.user.QUser;
import com.jun.crewchat.service.user.QUserEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class FriendDslRepositoryImpl extends QuerydslRepositorySupport implements FriendDslRepository {

    private final JPAQueryFactory jpaQueryFactory;
    QFriendEntity qFriend = QFriendEntity.friendEntity;
    QUserEntity qUser = QUserEntity.userEntity;

    public FriendDslRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(QFriendEntity.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<FriendDTO> getListMyFriend(FriendDTO dto) {
        return jpaQueryFactory
                .from(qFriend)
                .where(
                       qFriend.myEmail.eq(dto.getMyEmail())
                )
                .leftJoin(qUser)
                .on(qUser.email.eq(qFriend.friendEmail))
                .select(Projections.bean(FriendDTO.class,
                        qFriend.friendId
                        , qFriend.friendEmail
                        , qFriend.myEmail
                        , qUser.name
                ))
                .fetch();
    }

    @Override
    public FriendDTO friendCheck(FriendDTO dto) {
        return jpaQueryFactory
                .from(qFriend)
                .where(
                        qFriend.myEmail.eq(dto.getMyEmail())
                        , qFriend.friendEmail.eq(dto.getFriendEmail())
                )
                .select(Projections.bean(FriendDTO.class,
                        qFriend.friendId
                ))
                .fetchOne();
    }
}
