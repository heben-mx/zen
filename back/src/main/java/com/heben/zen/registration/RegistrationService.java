package com.heben.zen.registration;

import com.heben.zen.user.User;
import com.heben.zen.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final UserService userService;
    private final EmailValidator emailValidator;

    RegistrationService(UserService userService, EmailValidator emailValidator){
        this.userService = userService;
        this.emailValidator = emailValidator;
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
}
