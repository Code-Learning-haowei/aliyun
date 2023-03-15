package com.example.numbercheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class NumberCheckApp {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(NumberCheckApp.class);
        application.run(args);

    }
}
