package com.heben.zen.registration;

import com.heben.zen.registration.token.ConfirmationToken;
import com.heben.zen.registration.token.ConfirmationTokenService;
import com.heben.zen.user.User;
import com.heben.zen.user.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class RegistrationService {
    private final UserService userService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;

    RegistrationService(UserService userService,
                        EmailValidator emailValidator,
                        ConfirmationTokenService confirmationTokenService){
        this.userService = userService;
        this.emailValidator = emailValidator;
        this.confirmationTokenService = confirmationTokenService;
    }
    public String register(RegistrationRequest request) {
        boolean valid_email = emailValidator.test(request.getEmail());
        if (!valid_email) throw new IllegalArgumentException("email not valid");
        return userService.addNewUser(new User(
                request.getUsername(),
                request.getName(),
                request.getSurname(),
                request.getCountry(),
                request.getPhone_number(),
                request.getEmail(),
                request.getBirth_date(),
                request.getPassword(),
                request.getUserRole()
        ));
    }

    @Transactional
    public String confirm(String token){
        ConfirmationToken confirmationToken = confirmationTokenService.getToken(token)
                .orElseThrow(()-> new IllegalArgumentException("Token not found"));
        if (confirmationToken.getConfirmedAt() != null) throw new IllegalStateException();
        LocalDateTime expiredAt = confirmationToken.getExpiresAt();
        if (expiredAt.isBefore(LocalDateTime.now())){
            throw new IllegalStateException("token expired");
        }
        confirmationTokenService.setConfirmedAt(token);
        userService.enableUser(confirmationToken.getUser().getEmail());
        return "confirmed";
    }
}
