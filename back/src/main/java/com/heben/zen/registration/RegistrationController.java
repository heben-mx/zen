package com.heben.zen.registration;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService){
        this.registrationService = registrationService;
    }

    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return  registrationService.register(request);
    }

    @GetMapping("confirm")
    public String confirm(@RequestParam("token") String token){
        return registrationService.confirm(token);
    }

}
