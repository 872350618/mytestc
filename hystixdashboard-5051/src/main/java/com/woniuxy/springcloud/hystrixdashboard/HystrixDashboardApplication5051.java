package com.woniuxy.springcloud.hystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboardApplication5051 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication5051.class,args);
    }
}
