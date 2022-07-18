package com.heben.zen.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User Fred = new User("logan123",
                    "Fred",
                    "Random",
                    "Mexico",
                    "65465161",
                    "fake@email.com",
                    LocalDate.of(1990, 10, 5),
                    "test2022",
                    UserRole.USER
            );
            User Pancho = new User("spidy88",
                    "Pancho",
                    "Random",
                    "Mexico",
                    "1231314",
                    "lol@email.com",
                    LocalDate.of(2005, 2, 25),
                    "test2022",
                    UserRole.USER
            );
            repository.saveAll(List.of(Fred, Pancho));
        };

    }
}
