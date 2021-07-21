package com.example.stocknew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
        }
)
public class StockNewApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockNewApplication.class, args);
    }

}
