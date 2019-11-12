package com.sda.spring.boot.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    public static final String HELLO_VIEW = "hello";

    @RequestMapping(name = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(name = "/hello", method = RequestMethod.POST)
    public String sayHello(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return HELLO_VIEW;
    }
}
