package com.heben.zen.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserService {
    public List<User> getUsers(){
        List<Integer> followers = new ArrayList<>();
        List<Integer> following = new ArrayList<>();
        return List.of(new User(15L,
                "Fred",
                "Random",
                "Mexico",
                "65465161",
                "fake@email.com",
                LocalDate.of(1990, 10, 5),
                followers,
                following,
                new Date(),
                new Date()));
    }
}
