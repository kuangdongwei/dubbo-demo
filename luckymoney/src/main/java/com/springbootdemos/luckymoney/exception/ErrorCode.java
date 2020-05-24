package com.springbootdemos.luckymoney.exception;

import org.springframework.http.HttpStatus;

public enum  ErrorCode {
    RESOURCE_NOT_FOUND(1001, HttpStatus.NOT_FOUND,"资源未找到"),
    REQUEST_VALIDATION_FAILED(1002,HttpStatus.BAD_REQUEST,"参数错误"),
    SYSTEM_ERROR(1003,HttpStatus.INTERNAL_SERVER_ERROR,"内部服务错误");

    private final int code;
    private final HttpStatus status;
    private final String message;

     ErrorCode(int code,HttpStatus status,String message){
        this.code = code;
        this.status = status;
        this.message = message;
    }
    public int getCode() {
        return code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorCode{" +
                "code=" + code +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
