package com.example.testgatway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TestGatwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestGatwayApplication.class, args);
    }

}
