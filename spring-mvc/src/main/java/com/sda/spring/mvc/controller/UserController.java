package com.sda.spring.mvc.controller;

import com.sda.spring.mvc.model.User;
import com.sda.spring.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.List;

@Controller
public class UserController {

    // TODO: display a list of users

    // TODO: find the list of users

    // TODO: create edit users view

    @Autowired
    private UserService userService;

    // create mapping for method (end point)
    // this mapping is handled by the mapping handler
    @RequestMapping(name = "/users", method = RequestMethod.GET)
    public String userForm(Model model) {

        // whatever is added to the model will be available in the view
        List<User> userList = userService.list();
        model.addAttribute("users", userList);

        // this view will be returned by the view resolver
        return "editUsers";
    }

    // TODO: add user
    @PostMapping
    public String saveUser(@ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("users", userService.list());
            return "editUsers";
        }

        userService.save(user);
        return "redirect:/users";
    }
}
