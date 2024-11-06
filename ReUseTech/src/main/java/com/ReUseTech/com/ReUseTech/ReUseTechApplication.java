
package com.ReUseTech.com.ReUseTech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.ReUseTech")
public class ReUseTechApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReUseTechApplication.class, args);
    }

}
