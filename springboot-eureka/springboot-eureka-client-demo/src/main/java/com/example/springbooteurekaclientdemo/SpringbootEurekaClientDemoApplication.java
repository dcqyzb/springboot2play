package com.example.springbooteurekaclientdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootEurekaClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootEurekaClientDemoApplication.class, args);
    }

}
