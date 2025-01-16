package com.aaomile.controllers;

// import java.util.Optional;
import org.springframework.ui.Model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// import com.aaomile.entities.Login;
import com.aaomile.entities.User;
import com.aaomile.forms.UserReg;
// import com.aaomile.repository.LoginRepository;
import com.aaomile.repository.UserRepo;
import com.aaomile.service.EventService;
import com.aaomile.service.UserService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.aaomile.entities.Event;;


@Controller
@RequestMapping("/")
public class PageController {

    

    Logger logger = LoggerFactory.getLogger(this.getClass());
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
    // to give login view
    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }
 
    @RequestMapping("/Events-details")
    public String Eventsdetails(Model model) {
        return "Events-details";
    }
    @RequestMapping("/forgotpass")
    public String forgotpass(Model model) {
        return "forgotpass";
    }

    @Autowired 
    private EventService eventService;
    //to display events bycomedy comedy genre
    @RequestMapping("/home/comedy")
    public String eventByComedy(Model model){
        return"comedy";
    }
    @RequestMapping("/home/music")
    public String eventByMusic(Model model){
        return"music";
    }
    @RequestMapping("/home/workshop")
    public String eventByWorkshop(Model model){
        return"workshop";
    }
    @RequestMapping("/home/exhibition")
    public String eventByExhibition(Model model){
        return"exhibition";
    }
    @RequestMapping("/home/theater")
    public String eventByTheater(Model model){
        return"theater";
    }
    @RequestMapping("/home/hackathon")
    public String eventByHackathon(Model model){
        return"hackathon";
    }

    @RequestMapping("/event/{eventId}")
    public String showEventDetails(@PathVariable int eventId, Model model) {
    // Fetch the event by ID from your service
    Event event = eventService.getById(eventId);
    
    if (event != null) {
        model.addAttribute("event", event);
        return "sampleEventDisplay"; // Name of your template
    }
    
    return "redirect:/"; // Redirect to home if event not found
}

    // @RequestMapping("/book")
    // public String book(Model model) {
    //     return "user/book";
    // }

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

    // @RequestMapping("/after_login")
    // public String login(@RequestParam String email, @RequestParam String password, Model model) {
    //     if (userRepo.existsByEmailAndPassword(email, password)){
    //         System.out.println("\n\nemail= "+email+" password= "+password);
    //         System.out.println("Login Button Hit\nLOGIN STATUS --> Successful");

    //         // loginStatus =  true;
    //         model.addAttribute("LoggedInUser", email);
    //         return "user/after_login"; 
    //     } else {
    //         model.addAttribute("error", "Invalid ID or password");
    //         System.out.println("\n\nemail= "+email+" password= "+password);
    //         System.out.println("Login Button Hit\nLOGIN STATUS --> Unsuccessful");
    //         return "redirect:/login";
    //     }
    // }
    
    @Autowired
    private UserService userService;
    // to give registration view
    @RequestMapping("/signup")
    public String sigup(Model model) {
        UserReg userReg = new UserReg();
        model.addAttribute("userReg", userReg);
        return "signup";
    }

    // process registration
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String signup(@ModelAttribute UserReg userReg) {

        User user = User.builder()
        .firstName(userReg.getFirstName())
        .lastName(userReg.getLastName())
        .fullName(userReg.getFirstName()+" "+userReg.getLastName())
        .email(userReg.getEmail())
        .password(userReg.getPassword())
        .provider("SELF")
        .profilePic("/images/blank.jpg") // change link incase of default image change
        .build();


        userService.createUser(user);

        // System.out.println("created user");
        // System.out.println(userReg);
        // System.out.println("Processing User register");
        logger.info("---------------------------------------------------------------");
        logger.info("PROCESSING NEW SELF REGISTRATION");
        logger.info(userReg.toString());
        logger.info("CREATED NEW USER");
        
        return "redirect:/login";
    }

}
