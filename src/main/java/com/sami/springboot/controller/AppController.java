package com.sami.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pageTitle", "Accueil");
        return "index";
    }

    @GetMapping("/mentions-legales")
    public String mentions_legales(Model model) {
        model.addAttribute("pageTitle", "Mentions légales");
        return "mentions_légales";
    }
}
