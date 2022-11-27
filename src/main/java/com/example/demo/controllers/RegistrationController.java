package com.example.demo.controllers;

import com.example.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import role.User;


import java.io.FileNotFoundException;
import java.util.List;

@Controller
public class RegistrationController {

    static final Logger log = LoggerFactory.getLogger(MainController.class);

    private UserRepository userRepository = new UserRepository();

    @GetMapping("/REGISTRATION")
    public String REGISTRATION(Model model) {
        return "REGISTRATION";
    }

    @PostMapping("/registrationUser")
    public String loginUser(@ModelAttribute User user) throws FileNotFoundException {
        List<User> userList = userRepository.getAllUsers();

        log.error(user.toString());

        userRepository.addUser(new User(userList.size()+1, "user", user.getLogin(), user.getPassword(), user.getEmail()));

        for (User u: userList){
            if (u.getEmail().equalsIgnoreCase(user.getEmail()) && u.getPassword().equalsIgnoreCase(user.getPassword())){
                return "redirect:/Cars";
            }
        }
        return "redirect:/PROFILE";
    }
}
