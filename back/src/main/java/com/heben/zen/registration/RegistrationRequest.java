package com.heben.zen.registration;

import com.heben.zen.user.User;
import com.heben.zen.user.UserRole;

import java.time.LocalDate;

public class RegistrationRequest {
    private final String username;
    private final String name;
    private final String surname;
    private final String country;
    private final String phone_number;
    private final String email;
    private final LocalDate birth_date;
    private final String password;
    private final UserRole userRole = UserRole.USER;

    RegistrationRequest(String username, String name, String surname, String country, String phone_number, String email, LocalDate birth_date, String password){
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.phone_number = phone_number;
        this.email = email;
        this.birth_date = birth_date;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

}
