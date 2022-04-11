package com.heben.zen.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @GetMapping
    public User getUsers(){
        int[] followers = {};
        int[] following = {};
        return new User(15L,
                "Fred",
                "Random",
                "Mexico",
                "65465161",
                "fake@email.com",
                LocalDate.of(1990, 10, 5),
                followers,
                following,
                new Date(),
                new Date());
    }
}
