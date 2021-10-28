package com.example.coronavirusAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class CoronavirusAPIApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoronavirusAPIApplication.class, args);
    }
}
