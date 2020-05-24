package com.springbootdemos.luckymoney.exception;

import java.util.Map;

public class RequestValidationFailedException extends BaseException{
    public RequestValidationFailedException(Map<String,Object> data){
        super(ErrorCode.REQUEST_VALIDATION_FAILED,data);
    }
}
