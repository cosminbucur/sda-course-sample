package com.sda.spring.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    private static final Logger logger = LoggerFactory.getLogger(MyComponent.class);

    public void complexOperation() {
        String greeting = "hello";
        String anotherString = "world";
        logger.info("info message {} = some text {}", greeting, anotherString);
        logger.debug("debug message");
        logger.trace("trace message");
        logger.warn("warn message");
        logger.error("error message");
    }
}
