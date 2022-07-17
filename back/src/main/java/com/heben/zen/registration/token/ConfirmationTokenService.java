package com.heben.zen.registration.token;

import org.springframework.stereotype.Service;

@Service
public class ConfirmationTokenService {
    private final  ConfirmationTokenRepository confirmationTokenRepository;

    ConfirmationTokenService(ConfirmationTokenRepository confirmationTokenRepository){
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

    public void saveConfirmationToken(ConfirmationToken confirmationToken){
        confirmationTokenRepository.save(confirmationToken);
    }
}
