package com.stl.site_news.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsController {

    @GetMapping("/singleNews")
    public String news(Model model) {
        model.addAttribute("title", "ew");
        return "singleNews";
    }
}
