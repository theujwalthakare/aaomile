
package com.aaomile.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aaomile.entities.Login;
import com.aaomile.repository.UserRepository;

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
    @RequestMapping("user/CreateEvent")
    public String CreateEvent(Model model) {
        return "user/CreateEvent";
    }
    // @RequestMapping(value= "/after_login", method=RequestMethod.POST)
    // public String processLogin(@ModelAttribute Login login) {
    //     System.out.println(login);
    //     System.out.println("Login Button Hit");
    //     return"after_login";
    // }

    @Autowired
    private UserRepository userRepository;

    // @PostMapping("/login")
    @RequestMapping(value= "/after_login", method=RequestMethod.POST)
    public String login(@RequestParam String id, @RequestParam String password, Model model) {
        Optional<Login> user = userRepository.findByIdAndPassword(id, password);
        if (user.isPresent()) {
            return "after_login"; // Redirect to home page
        } else {
            // model.addAttribute("error", "Invalid ID or password");
            return "login";
        }
    }

}

