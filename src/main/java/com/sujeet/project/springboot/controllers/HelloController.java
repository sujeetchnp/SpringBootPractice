package com.sujeet.project.springboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myapp")
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
