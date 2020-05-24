package com.springbootdemos.luckymoney.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局捕获异常类：只要是抛出继承了BaseException异常类的异常
 * 都会在这里进行处理
 */
@ControllerAdvice(assignableTypes = {com.springbootdemos.luckymoney.controller.HelloController.class})
@ResponseBody
public class GlobalException {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<?> exceptionHandler(BaseException ex, HttpServletRequest request){
        ErrorResponse repsentation = new ErrorResponse(ex,request.getRequestURI());
        return new ResponseEntity<>(repsentation, new HttpHeaders(), ex.getErrorCode().getStatus());
    }
}
