package com.jun.crewchat.service.user;

import com.jun.crewchat.service.user.dsl.UserDslRepository;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>, UserDslRepository {
    @EntityGraph(attributePaths = {"roleSet"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("select m from UserEntity m where m.fromSocial = :social and m.email = :email")
    Optional<UserEntity> findByEmail(@Param("email") String email, @Param("social") boolean social);
}
