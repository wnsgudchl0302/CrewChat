package com.jun.crewchat.service.user;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jun.crewchat.service.base.DefaultEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
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
    protected String email;

    @Column(nullable = false)
    protected String password;

    @Column(nullable = false)
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
