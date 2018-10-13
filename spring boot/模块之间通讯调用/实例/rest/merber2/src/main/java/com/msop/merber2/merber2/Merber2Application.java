package com.msop.merber2.merber2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Merber2Application {

    public static void main(String[] args) {
        SpringApplication.run(Merber2Application.class, args);
    }
}
