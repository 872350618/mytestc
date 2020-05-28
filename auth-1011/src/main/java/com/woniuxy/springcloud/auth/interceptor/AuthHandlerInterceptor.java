package com.woniuxy.springcloud.auth.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.springcloud.auth.anno.RequiresPermssions;
import com.woniuxy.springcloud.auth.service.AuthService;
import com.woniuxy.springcloud.common.entity.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthHandlerInterceptor implements HandlerInterceptor {

    //Interceptor注入Bean,对象为null，必须注入当前拦截器的Bean
    @Autowired
    AuthService authService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("执行权限拦截");
        String token=request.getHeader("token");
        if(handler instanceof HandlerMethod){
            //当前的处理器是一个方法处理器才执行权限判断，权限注解是添加在Controller方法上的
            Method method=((HandlerMethod)handler).getMethod();
            if(method.isAnnotationPresent(RequiresPermssions.class)){
                RequiresPermssions requiresPermssion =
                        method.getAnnotation(RequiresPermssions.class);
                String permission=requiresPermssion.value();
                System.out.println("调用的方法:"+method+",需要权限:"+permission);
                if(!authService.hasPermission(token,permission)){
                    //没有权限
                    response.getWriter().write(new ObjectMapper().writeValueAsString(
                            new ResponseResult<String>(403,"nopermission")
                    ));
                    return false;
                }
            }
        }
        //放行
        return true;



    }
}
