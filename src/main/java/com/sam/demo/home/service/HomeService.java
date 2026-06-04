package com.sam.demo.home.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HomeService {

    public Map getMessage(){
        Map result = new HashMap<>();

        result.put("message", "Welcome to API 1.0");
        result.put("name", "Palash");
        result.put("contact", "01782396479");

        return result;
    }
}
