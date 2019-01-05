package com.framework.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.framework.controller"})
public class MySpringApplication {
    public static void main(String [] args){
        SpringApplication.run(MySpringApplication.class, args);
    }
}
