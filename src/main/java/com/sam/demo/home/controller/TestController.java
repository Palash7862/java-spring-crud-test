package com.sam.demo.home.controller;

import com.sam.demo.home.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/")
    public ResponseEntity<?> test() {
        return new ResponseEntity<>(homeService.getMessage(), HttpStatus.FOUND);
    }
}
