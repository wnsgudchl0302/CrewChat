package com.jun.crewchat.define;

public enum EUrl {
    
    DEFAULT_URL("/talk");

    private String url;

    EUrl(String url) {
        this.url = url;
    }

    public String getUrl() { return url; }
}
