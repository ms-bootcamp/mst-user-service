package com.thoughtworks.mstorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MstUserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MstUserServiceApplication.class, args);
    }
}
