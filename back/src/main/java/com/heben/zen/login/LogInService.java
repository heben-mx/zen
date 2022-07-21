package com.heben.zen.login;

import com.heben.zen.login.session_token.ContinueSessionRequest;
import com.heben.zen.login.session_token.SessionToken;
import com.heben.zen.login.session_token.SessionTokenService;
import com.heben.zen.security.Response;
import com.heben.zen.user.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LogInService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserService userService;
    private final SessionTokenService sessionTokenService;

    LogInService(BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService, SessionTokenService sessionTokenService){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
        this.sessionTokenService = sessionTokenService;
    }
    @Transactional
    public LogInResponse logIn(LogInRequest request) throws IllegalAccessException {
        String username = request.getUsername();
        String password = request.getPassword();
        UserDetails userDetails;
        try {
            userDetails = userService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e){
            throw new IllegalAccessException("Account not found. Verify username");
        }
        if (!(userDetails.isEnabled())){
            throw new IllegalAccessException("Account is disabled. Confirm registration is needed.");
        } else if (!userDetails.isAccountNonLocked()) {
            throw new IllegalAccessException("Account is locked");
        } else if (!userDetails.isAccountNonExpired()) {
            throw  new IllegalAccessException("Account is expired.");
        } else {
            if (bCryptPasswordEncoder.matches(password, userDetails.getPassword())){

                return new LogInResponse((short) 200,"OK", false , sessionTokenService.generateNewToken(username));
            } else {
                throw new IllegalAccessException("Wrong password.");
            }
        }
    }

    public Response validateSession(ContinueSessionRequest request){
        String token = request.getToken(), username = request.getUsername();
        Optional<SessionToken> sessionToken = sessionTokenService.findSessionToken(username, token);
        if (sessionToken.isEmpty()){
            throw new IllegalArgumentException("Session token doesn't exist");
        }
        return new Response((short) 200, false, "Success");
    }
}
