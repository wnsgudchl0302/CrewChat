package com.jun.crewchat.service.friendpost;

import com.jun.crewchat.service.friendpost.dsl.FriendPostDslRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendPostRepository extends JpaRepository<FriendPostEntity, String>, FriendPostDslRepository {
}
