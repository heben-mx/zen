package com.heben.zen.login.session_token;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SessionTokenService {
    private final SessionTokenRepository sessionTokenRepository;

    public SessionTokenService(SessionTokenRepository sessionTokenRepository){
        this.sessionTokenRepository = sessionTokenRepository;
    }

    public SessionToken generateNewToken(String username){
        SessionToken sessionToken = new SessionToken(username, UUID.randomUUID().toString());
        sessionTokenRepository.save(sessionToken);
        return  sessionToken;
    }

    public boolean isSessionTokenExpired(String username, String token){
        return sessionTokenRepository.isSessionTokenExpired(username, token);
    }
    public Optional<SessionToken> findSessionToken(String username, String token){
        return sessionTokenRepository.findSessionToken(username, token);
    }

}
