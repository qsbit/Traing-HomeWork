package com.jungle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//MVC model view controller
//controller service dao

@SpringBootApplication(scanBasePackages = {"cn.jungle", "com.jungle"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
