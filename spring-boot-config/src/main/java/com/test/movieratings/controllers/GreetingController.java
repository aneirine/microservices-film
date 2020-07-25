package com.test.movieratings.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Value("${app.description}")
    private String greetingMessage;

    @GetMapping("/greeting")
    public String greeting() {
        return greetingMessage;
    }
}
