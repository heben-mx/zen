package com.heben.zen.email;

public interface EmailSender {
    void send(String subject, String to, String email_content);
}
