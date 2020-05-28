package com.woniuxy.springcloud.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AuthApplication1011 {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication1011.class,args);
    }
}
