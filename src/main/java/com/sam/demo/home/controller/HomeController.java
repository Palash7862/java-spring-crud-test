package com.sam.demo.home.controller;

import com.sam.demo.home.service.HomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    private HomeService homeService;

    @GetMapping("/")
    public String home() {
         return "Hello Spring Boot test from docker n ppp pppp";
    }
}
