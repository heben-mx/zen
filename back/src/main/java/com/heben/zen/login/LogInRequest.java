package com.heben.zen.login;

public class LogInRequest {
    private final String username;
    private final String password;

    LogInRequest(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
