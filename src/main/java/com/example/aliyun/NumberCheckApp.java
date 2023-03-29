package com.example.aliyun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.example.aliyun.repository"})
@EnableAspectJAutoProxy
public class NumberCheckApp {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(NumberCheckApp.class);
        application.run(args);

    }
}
