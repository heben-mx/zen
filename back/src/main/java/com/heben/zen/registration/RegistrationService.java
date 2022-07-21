package com.heben.zen.registration;

import com.heben.zen.email.EmailSender;
import com.heben.zen.email.EmailService;
import com.heben.zen.registration.token.ConfirmationToken;
import com.heben.zen.registration.token.ConfirmationTokenService;
import com.heben.zen.security.Response;
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
    private final EmailSender emailSender;
    private final EmailService emailService;

    RegistrationService(UserService userService,
                        EmailValidator emailValidator,
                        ConfirmationTokenService confirmationTokenService,
                        EmailSender emailSender,
                        EmailService emailService){
        this.userService = userService;
        this.emailValidator = emailValidator;
        this.confirmationTokenService = confirmationTokenService;
        this.emailSender = emailSender;
        this.emailService = emailService;
    }
    public Response register(RegistrationRequest request) {
        boolean valid_email = emailValidator.test(request.getEmail());
        if (!valid_email) throw new IllegalArgumentException("email not valid");
        String token = userService.addNewUser(new User(
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
        String link = "http://localhost:8080/api/v1/registration/confirm?token=" + token;
        emailSender.send("Confirm your Zen account",
                request.getEmail(),
                emailService.buildRegistrationConfirmationEmail(request.getName(),
                        link));
        return new Response((short) 200, false, "Success");
    }

    @Transactional
    public String confirm(String token){
        ConfirmationToken confirmationToken = confirmationTokenService.getToken(token)
                .orElseThrow(()-> new IllegalArgumentException("Token not found"));
        if (confirmationToken.getConfirmedAt() != null) throw new IllegalStateException("Email already confirmed.");
        LocalDateTime expiredAt = confirmationToken.getExpiresAt();
        if (expiredAt.isBefore(LocalDateTime.now())){
            throw new IllegalStateException("token expired");
        }
        confirmationTokenService.setConfirmedAt(token);
        userService.enableUser(confirmationToken.getUser().getEmail());
        /* TODO: Improve response
        - Message
        - Error
        - Success
        - Status
         */
        return "confirmed";
    }
}
