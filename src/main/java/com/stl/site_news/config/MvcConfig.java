package com.stl.site_news.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/about").setViewName("about");
        registry.addViewController("/newsList").setViewName("newsList");
        registry.addViewController("/newsList/{id}").setViewName("newsList/{id}");

    }

}
