package com.sda.spring.boot.mvc.security;

import com.sda.spring.boot.mvc.security.dbauth.AppUser;
import com.sda.spring.boot.mvc.security.dbauth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMvcSecurityApplication {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcSecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            AppUser appUser = new AppUser();
            appUser.setUsername("admin");
            appUser.setPassword("pass");
            userRepository.save(appUser);
        };
    }
}
