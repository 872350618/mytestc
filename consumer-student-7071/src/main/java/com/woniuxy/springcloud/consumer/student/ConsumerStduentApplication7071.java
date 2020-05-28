package com.woniuxy.springcloud.consumer.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

//启用hystrix
@EnableHystrix
//启用feign调用
@EnableFeignClients
//启用服务发现
//@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class ConsumerStduentApplication7071 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerStduentApplication7071.class,args);
    }
}
