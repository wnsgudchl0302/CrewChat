package com.jun.crewchat.service.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity extends User {

    // Validation 체크할때 DTO랑 Entity가 계속 겹쳐서 오류 발생 - 분리
    @Column(nullable = false)
    private String password;
}
