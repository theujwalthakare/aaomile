
package com.aaomile.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import UserForms.Login;
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

    @RequestMapping(value= "/after_login", method=RequestMethod.POST)
    public String processLogin(@ModelAttribute Login login) {
        System.out.println(login);
        System.out.println("Login Button Hit");
        return"after_login";
    }

    //route
      
     
    //services
}
