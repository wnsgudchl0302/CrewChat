package com.jun.crewchat.service.friendpost;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "friend_post")
@Getter
@Setter
public class FriendPostEntity extends FriendPost{
}
