package com.woniuxy.springcloud.zuul.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.woniuxy.springcloud.common.entity.ResponseResult;
import com.woniuxy.springcloud.common.util.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter {
    //拦截的类型
    @Override
    public String filterType() {
        return "pre";
    }

    //拦截器的执行顺序，小的先执行
    @Override
    public int filterOrder() {
        return 0;
    }

    //是否执行拦截,拦截条件，拦截路径
    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String uri = request.getRequestURI();
        if(uri.contains("/auth")){
            //认证模块不拦截
            return false;
        }
        return true;
    }

    //拦截执行的方法，shouldFilter返回真才执行
    @Override
    public Object run() throws ZuulException {
        System.out.println("Zuul拦截");
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        //如何获取token:客户端token通过请求头传递
        String token = request.getHeader("token");
        if(!StringUtils.isEmpty(token) && JwtUtil.verify(token)){
            return null;
        }
        System.out.println("没有登录");
        //不经过后面的路由
        context.setSendZuulResponse(false);
        try{
            context.setResponseBody(new ObjectMapper().writeValueAsString(
                    new ResponseResult<String>(401,"loginfirst")
            ));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
