package com.sda.spring.mvc.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    // loads when GET request at http://localhost:8080/home
    @GetMapping(value = "/home", produces = MediaType.TEXT_PLAIN_VALUE)
    public String home() {
        return "this is the home page";
    }

}
