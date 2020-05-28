package com.woniuxy.springcloud.auth.controller;

import com.woniuxy.springcloud.common.entity.ResponseResult;
import com.woniuxy.springcloud.common.util.JwtUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/login")
    public ResponseResult<String> login(String uname,String pwd){
        if(uname.equals("a")&&pwd.equals("aaa")){
            //登录成功,生成token
            String token = JwtUtil.create(uname);
            return new ResponseResult<String>(200,
                    "loginsuceess",token);
        }
        return new ResponseResult<String>(401,
                "loginerror");
    }
}
