package com.stl.site_news.controllers;

import com.stl.site_news.models.Post;
import com.stl.site_news.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class NewsController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/newsList")
    public String news(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "newsListPage";
    }

    @GetMapping("/newsList/add")
    public String newsAdd(Model model) {
        return "newsAdd";
    }

    @PostMapping("/newsList/add")
        public String newNewsAdd(@RequestParam String title,@RequestParam String anons,@RequestParam String full_text, Model model) {
            Post post = new Post(title, anons, full_text);
            postRepository.save(post);
            return "redirect:/newsList";
        }
    @GetMapping("/singleNews/{id}")
    public String newsDetails(@PathVariable(value = "id") long id, Model model) {
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> result = new ArrayList<>();
        post.ifPresent(result::add);
        model.addAttribute("post", result);
        return "newsDetails";
    }
}
