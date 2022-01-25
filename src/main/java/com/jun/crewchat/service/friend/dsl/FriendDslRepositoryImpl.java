package com.jun.crewchat.service.friend.dsl;

import com.jun.crewchat.service.friend.FriendDTO;
import com.jun.crewchat.service.friend.QFriendEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class FriendDslRepositoryImpl extends QuerydslRepositorySupport implements FriendDslRepository {

    private final JPAQueryFactory jpaQueryFactory;
    QFriendEntity qFriend = QFriendEntity.friendEntity;

    public FriendDslRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(QFriendEntity.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<FriendDTO> isFriend(String myEmail, String friendEmail) {
        return jpaQueryFactory
                .from(qFriend)
                .where(
                        qFriend.myEmail.eq(myEmail).or(qFriend.myEmail.eq(friendEmail))
                        , qFriend.friendEmail.eq(friendEmail).or(qFriend.friendEmail.eq(myEmail))
                )
                .select(Projections.bean(FriendDTO.class,
                        qFriend.friendId
                ))
                .fetch();
    }
}
