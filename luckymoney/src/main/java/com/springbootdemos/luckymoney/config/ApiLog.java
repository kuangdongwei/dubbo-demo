package com.springbootdemos.luckymoney.config;

import java.lang.annotation.*;

/**
 * 自定义api操作记录日志注解
 */
@Target({ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiLog {
    //操作类型
//    String type() default "";
    //操作描述
    String description() default "";
}
