package com.jun.crewchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CrewChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrewChatApplication.class, args);
    }

}
