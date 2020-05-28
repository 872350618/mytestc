package com.woniuxy.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
//启用网关
@EnableZuulProxy
@SpringBootApplication
public class ZullApplication9091 {
    public static void main(String[] args) {
        SpringApplication.run(ZullApplication9091.class,args);
    }

}
