package com.jun.crewchat.user;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class User {

    @Id
    protected String email;

    @Column(nullable = false)
    protected  String password;

    @Column(nullable = false)
    protected String name;

    protected String profileImg;

    @Column(nullable = false)
    protected boolean fromSocial;

    protected  boolean socialImg;

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<UserRole> roleSet = new HashSet<>();

    public void addUserRole(UserRole userRole){
        roleSet.add(userRole);
    }
}
