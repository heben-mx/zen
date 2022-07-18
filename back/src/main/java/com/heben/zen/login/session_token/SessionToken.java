package com.heben.zen.login.session_token;

import javax.persistence.*;

@Entity
public class SessionToken {
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
    @Column(name = "id", nullable = false)
    private Long id;

    private final String username;
    private final String token;


    SessionToken(String username, String token){
        this.username = username;
        this.token = token;
    }

    public SessionToken() {
        this.username = null;
        this.token = null;
    }

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }


}
