package com.sda.spring.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBoot2Application {

    private static final Logger log = LoggerFactory.getLogger(SpringBoot2Application.class);

    @Autowired
    private MyComponent myComponent;

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2Application.class);
    }

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            log.info("from main");
            myComponent.complexOperation();
        };
    }
}

