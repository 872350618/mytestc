package com.woniuxy.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//启用Eureka服务端
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication6061 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication6061.class,args);
    }
}
