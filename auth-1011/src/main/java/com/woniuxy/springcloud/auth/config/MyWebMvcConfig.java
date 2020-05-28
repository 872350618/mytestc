package com.woniuxy.springcloud.auth.config;

import com.woniuxy.springcloud.auth.interceptor.AuthHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfig  {
    //Interceptor注入Bean,对象为null，必须注入当前拦截器的Bean
    @Bean
    public AuthHandlerInterceptor authHandlerInterceptor(){
        return  new AuthHandlerInterceptor();
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return  new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(authHandlerInterceptor()).
                    addPathPatterns("/**");
            }
        };
    }
}
