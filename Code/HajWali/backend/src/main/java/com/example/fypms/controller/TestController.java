package com.example.fypms.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000") // Allow your React app to access this endpoint
@RestController
public class TestController {

    @GetMapping("/api/auth/test") // URL path to call this API
    public String testApi() {
        return "Backend is working!";
    }
}
