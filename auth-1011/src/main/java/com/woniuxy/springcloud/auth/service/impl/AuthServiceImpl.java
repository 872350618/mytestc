package com.woniuxy.springcloud.auth.service.impl;

import com.woniuxy.springcloud.auth.service.AuthService;
import com.woniuxy.springcloud.common.util.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public boolean hasPermission(String token, String permission) {
        System.out.println("hasPermission：token:"+token);
        String uname = JwtUtil.getUname(token);
        //Dao查询权限
        List<String> permissions=new ArrayList<String>();
        permissions.add("student:insert");
        permissions.add("student:select");
        return permissions.contains(permission);
    }
}
