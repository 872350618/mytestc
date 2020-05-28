package com.woniuxy.springcloud.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult<T> implements Serializable {
    private Integer stateCode;
    private String message;
    private T data;

    public  ResponseResult(Integer stateCode,String message){
        this(stateCode,message,null);
    }
}
