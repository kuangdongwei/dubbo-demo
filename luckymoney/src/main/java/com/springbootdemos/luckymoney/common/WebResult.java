package com.springbootdemos.luckymoney.common;

import lombok.Data;

/**
 * 返回结果统一封装
 */
@Data
public class WebResult {

    private boolean result;
    private int code;
    private String message;
    private Object data;
    public WebResult(boolean result){
        this.result = result;
    }

    public static WebResult succcess(String message){
        WebResult webResult = new WebResult(true);
        webResult.code = 200;
        webResult.message = message;
        return webResult;
    }

    public static WebResult succcess(String message,Object data){
        WebResult webResult = new WebResult(true);
        webResult.code = 200;
        webResult.message = message;
        webResult.data = data;
        return webResult;
    }

    public static WebResult failed(int code,String message){
        WebResult webResult = new WebResult(false);
        webResult.code = code;
        webResult.message = message;
        return webResult;
    }
}
