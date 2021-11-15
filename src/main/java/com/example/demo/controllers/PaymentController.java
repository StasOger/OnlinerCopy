package com.example.demo.controllers;

import com.example.demo.model.Card;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaymentController {

    @GetMapping("/PAYMENT")
    public String PAYMENT(Model model) {
        model.addAttribute("card", new Card());
        return "PAYMENT";
    }

    @PostMapping("/createCard")
    public String createCard(@ModelAttribute Card card) {


        return "redirect:/cvc_kode";
    }

}