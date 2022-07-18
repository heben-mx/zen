package com.heben.zen.login;

import com.heben.zen.user.User;
import com.heben.zen.user.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class LogInService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserService userService;

    LogInService(BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
    }
    @Transactional
    public String logIn(LogInRequest request) throws IllegalAccessException {
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
                return UUID.randomUUID().toString();
            } else {
                throw new IllegalAccessException("Wrong password.");
            }
        }
    }
}
