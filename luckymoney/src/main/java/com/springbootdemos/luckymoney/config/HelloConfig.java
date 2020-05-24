package com.springbootdemos.luckymoney.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 对象配置类
 */
@Component
@ConfigurationProperties(prefix = "limit")
public class HelloConfig {
    private BigDecimal min;  //最小金额
    private BigDecimal max;  //最大金额
    private String description;  //描述

    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    public BigDecimal getMax() {
        return max;
    }

    public void setMax(BigDecimal max) {
        this.max = max;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
