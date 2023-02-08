package com.example.springbootcachedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootCacheDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCacheDemoApplication.class, args);
    }

}
