package com.heben.zen.login;

import com.heben.zen.login.session_token.ContinueSessionRequest;
import com.heben.zen.security.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/login")
public class LogInController {
    private final LogInService logInService;

    LogInController(LogInService logInService){
        this.logInService = logInService;
    }

    @PostMapping
    public LogInResponse logInUser(@RequestBody LogInRequest request) throws IllegalAccessException {
        return logInService.logIn(request);
    }

    @PutMapping
    public Response continueLogin(@RequestBody ContinueSessionRequest request){
        return logInService.validateSession(request);
    }
}
