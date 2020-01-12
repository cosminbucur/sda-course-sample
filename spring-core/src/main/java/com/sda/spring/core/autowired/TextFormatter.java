package com.sda.spring.core.autowired;

import org.springframework.stereotype.Component;

@Component
public class TextFormatter {

    public void format() {
        System.out.println("formatting...");
    }
}
