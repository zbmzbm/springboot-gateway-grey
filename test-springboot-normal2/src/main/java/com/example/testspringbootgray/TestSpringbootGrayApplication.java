package com.example.testspringbootgray;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TestSpringbootGrayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSpringbootGrayApplication.class, args);
    }

}
