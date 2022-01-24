package com.jun.crewchat.service.user.dsl;

import com.jun.crewchat.service.user.QUserEntity;
import com.jun.crewchat.service.user.UserDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class UserDslRepositoryImpl extends QuerydslRepositorySupport implements UserDslRepository {

    private final JPAQueryFactory jpaQueryFactory;
    QUserEntity qUser = QUserEntity.userEntity;

    public UserDslRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(QUserEntity.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<UserDTO> getList(UserDTO dto) {
        return jpaQueryFactory
                .from(qUser)
                .select(Projections.bean(UserDTO.class,
                        qUser.email
                        , qUser.name
                        , qUser.fromSocial
                        , qUser.socialType
                        , qUser.profileImg
                ))
                .fetch();
    }

    @Override
    public UserDTO getMyInfo(UserDTO dto) {
        return jpaQueryFactory
                .from(qUser)
                .where(qUser.email.eq(dto.getEmail()))
                .select(Projections.bean(UserDTO.class,
                        qUser.email
                        , qUser.name
                        , qUser.fromSocial
                        , qUser.socialType
                        , qUser.profileImg
                ))
                .fetchFirst();
    }
}
