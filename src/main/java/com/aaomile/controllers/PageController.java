package com.aaomile.controllers;

// import java.util.Optional;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// import com.aaomile.entities.Login;
import com.aaomile.entities.User;
import com.aaomile.forms.UserReg;
// import com.aaomile.repository.LoginRepository;
import com.aaomile.repository.UserRepo;
import com.aaomile.service.UserService;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class PageController {
    
    @RequestMapping("/")
    public String index(Model model) {
        return "home";
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

    // @RequestMapping(value= "/after_login", method=RequestMethod.POST)
    // public String processLogin(@ModelAttribute Login login) {
    //     System.out.println(login);
    //     System.out.println("Login Button Hit");
    //     return"after_login";
    // }

    // @Autowired
    // private LoginRepository loginRepository;
    
    // @RequestMapping(value= "/after_login", method=RequestMethod.POST)
    // @PostMapping("/after_login")
    // public String login(@RequestParam String id, @RequestParam String password, Model model) {
    //     Optional<User> user = loginRepository.findByEmailAndPassword(id, password);
    //     System.out.println("Login Button Hit");
    //     if (user.isPresent()) {
    //         return "after_login"; 
            
    //     } else {
    //         model.addAttribute("error", "Invalid ID or password");
    //         return "login";
    //     }
    // }

    @Autowired
    private UserRepo userRepo;

    @RequestMapping("/after_login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        if (userRepo.existsByEmailAndPassword(email, password)){
            System.out.println("\n\nemail= "+email+" password= "+password);
            System.out.println("Login Button Hit\nLOGIN STATUS --> Successful");
            return "after_login"; 
        } else {
            model.addAttribute("error", "Invalid ID or password");
            System.out.println("\n\nemail= "+email+" password= "+password);
            System.out.println("Login Button Hit\nLOGIN STATUS --> Unsuccessful");
            return "login";
        }
    }
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/signup")
    public String sigup(Model model) {
        UserReg userReg = new UserReg();
        model.addAttribute("userReg", userReg);
        return "signup";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String signup(@ModelAttribute UserReg userReg) {

        User user = User.builder()
        .firstName(userReg.getFirstName())
        .lastName(userReg.getLastName())
        .email(userReg.getEmail())
        .password(userReg.getPassword())
        .build();

        userService.createUser(user);

        System.out.println("created user");
        System.out.println(userReg);
        System.out.println("Processing User register");


        return "redirect:/login";
    }

}
