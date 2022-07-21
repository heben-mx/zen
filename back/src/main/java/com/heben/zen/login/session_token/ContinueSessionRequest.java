package com.heben.zen.login.session_token;

public class ContinueSessionRequest {
    private final String username;
    private final String token;
    public ContinueSessionRequest(String username, String token){
        this.username = username;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }
}
