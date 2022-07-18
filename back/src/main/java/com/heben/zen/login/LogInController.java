package com.heben.zen.login;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/login")
public class LogInController {
    private final LogInService logInService;

    LogInController(LogInService logInService){
        this.logInService = logInService;
    }

    @PostMapping
    public String logInUser(@RequestBody LogInRequest request) throws IllegalAccessException {
        return logInService.logIn(request);
    }
}
