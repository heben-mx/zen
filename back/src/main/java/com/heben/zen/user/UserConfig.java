package com.heben.zen.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User Fred = new User("Fred",
                    "Random",
                    "Mexico",
                    "65465161",
                    "fake@email.com",
                    LocalDate.of(1990, 10, 5),
                    List.of(1),
                    List.of(2),
                    new Date(),
                    new Date(),
                    "test2022"
            );
            User Pancho = new User("Pancho",
                    "Random",
                    "Mexico",
                    "1231314",
                    "lol@email.com",
                    LocalDate.of(2005, 2, 25),
                    List.of(2),
                    List.of(1),
                    new Date(),
                    new Date(),
                    "test2022"
            );
            repository.saveAll(List.of(Fred, Pancho));
        };

    }
}
