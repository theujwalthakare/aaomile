
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
    public String about(Model model) {
        return "signup";
    }
    @RequestMapping("/about")
    public String login(Model model) {
        return "about";
    }
    @RequestMapping("/navbar")
    public String contact(Model model) {
        return "navbar";
    }

    @RequestMapping("/create_event")
    public String create_event(Model model) {
        return "create_event";
    }
    //route
      
     
    //services
}
