package com.springbootdemos.luckymoney.service.impl;

import com.alibaba.fastjson.JSON;
import com.springbootdemos.luckymoney.config.ApiLog;
import com.springbootdemos.luckymoney.model.Order;
import com.springbootdemos.luckymoney.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceImplTest {

    @Resource
    private OrderService orderService;
    @Test
    @ApiLog(description = "测试新增订单")
    public void insertOrder() {
        Order order = new Order();
        order.setOrderId(2020042001);
        order.setUserId(111);
        order.setUserName("james");
        order.setGoods("big house");
        order.setPayment(new BigDecimal("20000000.88").longValue());
        System.out.println(JSON.toJSON(orderService.insertOrder(order)));
    }

    @Test
    public void findOrder() {
        System.out.println(JSON.toJSON(orderService.findOrder(2020041901)));

    }

    @Test
    public void updateOrder() {
    }

    @Test
    public void deleteOrder(){
        log.info(JSON.toJSONString(orderService.deleteOrder(2020041903)));
    }

}