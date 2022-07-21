package com.heben.zen.login;

import com.heben.zen.login.session_token.SessionToken;
import com.heben.zen.security.Response;

public class LogInResponse extends Response {
    private final SessionToken token;

    public LogInResponse(short status, String message, boolean error, SessionToken token){
        super(status, error, message);
        this.token = token;
    }

    public SessionToken getToken() {
        return token;
    }
}
