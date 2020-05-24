package com.springbootdemos.luckymoney.controller;

import com.springbootdemos.luckymoney.common.WebResult;
import com.springbootdemos.luckymoney.config.ApiLog;
import com.springbootdemos.luckymoney.model.Order;
import com.springbootdemos.luckymoney.model.PersonDto;
import com.springbootdemos.luckymoney.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @ApiLog(description = "post 新增订单")
    @PostMapping("/add")
    public WebResult produceOrder(@RequestBody @Valid Order order){
        return orderService.insertOrder(order);
    }

    @ApiLog(description = "get 查询订单")
    @GetMapping("/get")
    public WebResult getOrderInfo(@RequestParam(required = true) Integer orderId){
        return orderService.findOrder(orderId);
    }

    @PostMapping("/addPerson")
    public void addPerson(@RequestBody PersonDto personDto){
        //打印每个属性
        System.out.println("ID=" + personDto.getId());
        System.out.println("NAME=" + personDto.getName());
        System.out.println("SEX=" + personDto.getSex());
        System.out.println("AGE=" + personDto.getAge());
    }
}
