package com.springbootdemos.luckymoney.common;

/**
 * 结果枚举类型
 */
public enum ResultEnum {
    SUCCESS(200,"操作成功"),
    SERVER_ERROR(1000,"服务错误"),
    DATABASE_ERROR(2000,"数据库错误"),
    UNKNOWN_ERROR(3000,"位置错误"),
    RESOURCE_NOT_FOUND(404,"资源未找到");

    ResultEnum(int code,String message){
        this.code = code;
        this.message = message;
    }
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
