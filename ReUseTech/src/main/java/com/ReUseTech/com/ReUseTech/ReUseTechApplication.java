package com.ReUseTech.com.ReUseTech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ReUseTech")
public class ReUseTechApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReUseTechApplication.class, args);
    }

}