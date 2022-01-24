package com.jun.crewchat.service.friend;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "friend")
@Getter
@Setter
public class FriendEntity extends Friend{
}
