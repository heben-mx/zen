package com.heben.zen.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="\"user\"")
public class User implements UserDetails {
    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String username;
    private String name;
    private String surname;
    private String country;
    private String phone_number;
    private String email;
    private LocalDate birth_date;
    @ElementCollection
    private List<Integer> followers;
    @ElementCollection
    private List<Integer> following;
    private Date creation_date;
    private Date last_update;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole = UserRole.USER;
    private Boolean locked = false;
    private Boolean enabled = false;

    public User(String username, String name, String surname, String country, String phone_number, String email, LocalDate birth_date, String password, UserRole userRole) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.phone_number = phone_number;
        this.email = email;
        this.birth_date = birth_date;
        this.creation_date = new Date();
        this.last_update = new Date();
        this.password = password;
        this.userRole = userRole;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public List<Integer> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Integer> followers) {
        this.followers = followers;
    }

    public List<Integer> getFollowing() {
        return following;
    }

    public void setFollowing(List<Integer> following) {
        this.following = following;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return Period.between(this.birth_date, LocalDate.now()).getYears();
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
     public Collection<? extends GrantedAuthority> getAuthorities() {
         SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
         return Collections.singletonList(authority);
     }

     @Override
     public boolean isAccountNonExpired() {
         return true;
     }

     @Override
     public boolean isAccountNonLocked() {
         return !locked;
     }

     @Override
     public boolean isCredentialsNonExpired() {
         return true;
     }

     @Override
     public boolean isEnabled() {
         return enabled;
     }

}
