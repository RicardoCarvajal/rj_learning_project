package com.ricardo.Practica_16_spring_boot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Practica16SpringBootApplication {

    @RequestMapping("/hello")
    public String hello(Model model) {

        model.addAttribute("saludo", "Spring Boot");

        return "hello";

    }

    public static void main(String[] args) {
        // SpringApplication.run(Practica16SpringBootApplication.class, args);

        SpringApplication app = new SpringApplication(Practica16SpringBootApplication.class);

        app.setBannerMode(Banner.Mode.OFF);

        app.run(args);

    }
}
