package com.woniuxy.springcloud.provider.student;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.woniuxy.springcloud")
//启用Eureka客户端
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.woniuxy.springcloud.provider.student.mapper")
public class ProviderStudentApplication8081 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderStudentApplication8081.class,args);
    }
}
