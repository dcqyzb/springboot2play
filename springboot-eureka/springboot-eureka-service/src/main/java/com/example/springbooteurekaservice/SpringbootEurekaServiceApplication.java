package com.example.springbooteurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringbootEurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootEurekaServiceApplication.class, args);
    }

}
