package com.example.demo.controllers;

import com.example.demo.model.Card;
import com.example.demo.model.Cvc;
import com.example.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import role.User;

import java.util.List;


@Controller
public class MainController {

    static final Logger log = LoggerFactory.getLogger(MainController.class);

    private UserRepository userRepository = new UserRepository();

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "have we go again");
        return "/";
    }

    @PostMapping("/loginUser")
    public String loginUser(@ModelAttribute User user)
    {
        List<User> userList = userRepository.getAllUsers();

        log.error(user.toString());

        for (User u: userList){
            if (u.getEmail().equalsIgnoreCase(user.getEmail()) && u.getPassword().equalsIgnoreCase(user.getPassword())){
                return "redirect:/Cars";
            }
        }
        return "redirect:/PROFILE";
    }

    @GetMapping("/support")
    public String support(Model model) {
        model.addAttribute("title", "have we go again");
        return "support";
    }



  //  public void example() {
  //      String[] myString = new String[]{"раз", "два", "три", "четыре", "пять"};
  //      int n = (int)Math.floor(Math.random() * myString.length);
  //      System.out.println(myString[n]);
 //   }


}