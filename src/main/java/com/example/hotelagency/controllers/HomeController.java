package com.example.hotelagency.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/offer")
    public ModelAndView detailsPage() {
        ModelAndView modelAndView = new ModelAndView("detailsPage");
        return modelAndView;
    }

    @GetMapping("/comparateur")
    public ModelAndView comparateurPage() {
        ModelAndView modelAndView = new ModelAndView("comparateur");
        return modelAndView;
    }
}
