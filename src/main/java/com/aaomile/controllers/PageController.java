
package com.aaomile.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class PageController {
    
    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }
    @RequestMapping("/signup")
    public String about(Model model) {
        return "signup";
    }
}
