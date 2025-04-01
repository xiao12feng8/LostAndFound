package com.example.lostandfound.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LostAndFoundController {

    @GetMapping("/")
    public String test() {
        return "Hello world";
    }
}