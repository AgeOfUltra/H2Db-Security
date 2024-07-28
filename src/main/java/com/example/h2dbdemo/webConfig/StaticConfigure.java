package com.example.h2dbdemo.webConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class StaticConfigure implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home.html");
        registry.addViewController("/home").setViewName("home.html");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/home/welcome").setViewName("welcome.html");
//        registry.addViewController("/displayMessages").setViewName("displayMessages.html"); // this page is going to be a dynamic page, so we need to add define RequestMapping in Controller
    }
}
