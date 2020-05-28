package com.woniuxy.springcloud.auth.service;

public interface AuthService {
    public boolean hasPermission(String token,String permission);
}
