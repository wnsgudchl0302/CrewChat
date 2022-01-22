package com.jun.crewchat.define;

public enum ESocialClient {
    KAKAO("Kakao"),
    GOOGLE("Google");

    private String name;

    ESocialClient(String name) {
        this.name = name;
    }

    public String getName() { return name; }
}
