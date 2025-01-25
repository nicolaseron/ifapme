package com.example.spring_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

//    public static void main(String[] args) {
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        String encodedPassword = "user";
//        encoder.encode(encodedPassword);
//        System.out.println( encoder.encode(encodedPassword));
//    }
}
