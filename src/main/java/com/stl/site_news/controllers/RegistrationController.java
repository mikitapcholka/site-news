package com.stl.site_news.controllers;

import com.stl.site_news.models.User;
import com.stl.site_news.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String newUserAdd(@RequestParam String username,@RequestParam String password, Model model) {
            User user = new User(username, password);
            userRepository.save(user);

        return "redirect:/newsList";
    }

    @GetMapping("/entry")
    public String entry(Model model) {
        return "entry";
    }

    @PostMapping("/entry")
    public String loginCheck(@RequestParam String username, @RequestParam String password, Model model){
        User user = userRepository.findByUsername(username);
        if(user.getPassword().equals(password)){
            return "redirect:/control";
        }
        else return "entry";
    }
}
