package com.jun.crewchat.service.friend;

import com.jun.crewchat.service.friend.dsl.FriendDslRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository<FriendEntity, String>, FriendDslRepository {
}
