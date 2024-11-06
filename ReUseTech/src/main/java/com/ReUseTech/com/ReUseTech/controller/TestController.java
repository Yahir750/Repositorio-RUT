package com.ReUseTech.com.ReUseTech.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // Ruta básica que devuelve un mensaje simple
    @GetMapping("/test")
    public String test() {
        return "Application is working!";
    }
}