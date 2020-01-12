package com.sda.spring.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(CustomCommandLineRunner.class);

    @Autowired
    private MyComponent myComponent;

    @Override
    public void run(String... args) throws Exception {
        log.info("--- in custom command line runner");
        myComponent.complexOperation();
    }
}
