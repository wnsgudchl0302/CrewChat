package com.jun.crewchat.service.friendpost.dsl;

import com.jun.crewchat.service.friendpost.FriendPostDTO;
import com.jun.crewchat.service.friendpost.QFriendPostEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class FriendPostDslRepositoryImpl extends QuerydslRepositorySupport implements FriendPostDslRepository{

    private final JPAQueryFactory jpaQueryFactory;
    QFriendPostEntity qFriendPost = QFriendPostEntity.friendPostEntity;

    public FriendPostDslRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(QFriendPostEntity.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public FriendPostDTO isRequesting(String sender, String receiver) {
        return jpaQueryFactory
                .from(qFriendPost)
                .where(
                        qFriendPost.sender.eq(sender).or(qFriendPost.sender.eq(receiver))
                        , qFriendPost.receiver.eq(receiver).or(qFriendPost.receiver.eq(sender))
                )
                .select(Projections.bean(FriendPostDTO.class,
                        qFriendPost.friendPostId
                        , qFriendPost.receiver
                        , qFriendPost.sender
                        , qFriendPost.requestType
                ))
                .fetchFirst();
    }
    @Override
    public FriendPostDTO isRequestingOnlyMe(String sender, String receiver) {
        return jpaQueryFactory
                .from(qFriendPost)
                .where(
                        qFriendPost.sender.eq(sender)
                        , qFriendPost.receiver.eq(receiver)
                )
                .select(Projections.bean(FriendPostDTO.class,
                        qFriendPost.friendPostId
                        , qFriendPost.receiver
                        , qFriendPost.sender
                        , qFriendPost.requestType
                ))
                .fetchFirst();
    }
}
