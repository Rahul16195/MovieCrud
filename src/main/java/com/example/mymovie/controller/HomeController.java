package com.example.mymovie.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String sayHello() {
        return "Hello and Welcome to the Mymovie Crud. You can create a new movie by making a POST request to /api/movie endpoint.";
    }
}