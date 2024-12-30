
package com.aaomile.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;


@Controller
public class PageController {
    
    @RequestMapping("/")
    public String index(Model model) {
        return "home";
    }
    @RequestMapping("/signup")
    public String sigup(Model model) {
        return "signup";
    }
    @RequestMapping("/about")
    public String about(Model model) {
        return "about";
    }
    @RequestMapping("/navbar")
    public String contact(Model model) {
        return "navbar";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }
    
    @RequestMapping("/Shows")
    public String Shows(Model model) {
        return "Shows";
    }
    @RequestMapping("/Events")
    public String Events(Model model) {
        return "Events";
    }
    //route
      
     
    //services
}
