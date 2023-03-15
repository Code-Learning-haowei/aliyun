package com.example.numbercheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NumberCheckApp {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(NumberCheckApp.class);
        application.run(args);

    }
}
