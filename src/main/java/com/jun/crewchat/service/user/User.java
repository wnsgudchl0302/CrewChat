package com.jun.crewchat.service.user;

import com.jun.crewchat.service.base.DefaultEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class User extends DefaultEntity {

    @Id
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식에 맞지 않습니다.")
    protected String email;

    @Column(nullable = false)
    @NotBlank(message = "이름은 필수 입력 값입니다.")
    protected String name;

    protected String profileImg;

    @Column(nullable = false)
    protected boolean fromSocial;

    protected boolean socialImg;

    @ElementCollection(fetch = FetchType.LAZY)
    private Set<UserRole> roleSet = new HashSet<>();

    public void addUserRole(UserRole userRole) {
        roleSet.add(userRole);
    }
}
