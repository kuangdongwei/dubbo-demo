package com.springbootdemos.luckymoney.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * 切面日志配置
 */
@Slf4j
@Aspect
@Component
public class ApiLogAspect {

    //controller层切入点
    @Pointcut("@annotation(com.springbootdemos.luckymoney.config.ApiLog)")
    public void apiLog(){}

    @Before("apiLog() && @annotation(thisapiLog)")
    public void beforeController(JoinPoint joinPoint,ApiLog thisapiLog){

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes)requestAttributes).getRequest();
        //请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //请求的方法名
        String operateMethod = joinPoint.getSignature().getName();
        //请求入参
        StringBuilder stringBuilder = new StringBuilder();
        Object[] requestArgs = joinPoint.getArgs();
        for (int i = 0; i < requestArgs.length; i++) {
            stringBuilder.append(JSON.toJSONString(requestArgs[i]));
        }
        //请求路径
        String uri = httpServletRequest.getRequestURI();
        //用户id
        String uid = httpServletRequest.getSession().getId();
        //注解中的描述参数
        String description = thisapiLog.description();

        log.info("---------------前置通知-------------");
        log.info("用户id："+uid);
        log.info("请求类路径："+className);
        log.info("请求方法名："+operateMethod);
        log.info("请求入参："+stringBuilder.toString());
        log.info("请求路径："+uri);
        log.info("请求接口描述："+description);
    }

    @AfterReturning("apiLog()")
    public void afterController(JoinPoint joinPoint){
        log.info("----------后置通知----------");
        log.info("成功返回的消息："+JSON.toJSONString(joinPoint.getArgs()));
    }

    @AfterThrowing("apiLog()")
    public void afterException(JoinPoint joinPoint){
        log.error("------------异常通知--------------");
        log.error(JSON.toJSONString(joinPoint.getArgs()));
    }
}
