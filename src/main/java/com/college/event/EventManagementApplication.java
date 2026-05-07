package com.college.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(EventManagementApplication.class, args);
        System.out.println("College Event Management System Started Successfully!");
        System.out.println("Access at: http://localhost:8080");
    }
}
