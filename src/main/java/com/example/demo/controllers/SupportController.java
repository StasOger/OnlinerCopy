package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupportController {

    @GetMapping("/SUPPORT")
    public String SUPPORT(Model model) {
        return "SUPPORT";
    }

    public String BUTTON(Model model) {
        return "BUTTON";
    }
}