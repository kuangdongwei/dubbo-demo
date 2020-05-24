package com.springbootdemos.luckymoney.service.impl;

import com.springbootdemos.luckymoney.common.ResultEnum;
import com.springbootdemos.luckymoney.common.WebResult;
import com.springbootdemos.luckymoney.dao.OrderMapper;
import com.springbootdemos.luckymoney.dao.UserAccountMapper;
import com.springbootdemos.luckymoney.model.Order;
import com.springbootdemos.luckymoney.model.UserAccount;
import com.springbootdemos.luckymoney.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private  OrderMapper orderMapper;
    @Resource
    private UserAccountMapper userAccountMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public WebResult insertOrder(Order order) {
        int result = 0;
        //从用户账户中扣款
        UserAccount userAccount = userAccountMapper.selectByUserId(order.getUserId());
        //检查账户余额是否足够支付该订单,小于则直接返回余额不足
        if (userAccount.getAccount() < order.getPayment()){
            return WebResult.failed(200,"您的余额不足！");
        }
        Long restAccount = userAccount.getAccount()-order.getPayment();
        userAccount.setAccount(restAccount);
        userAccountMapper.updateByPrimaryKey(userAccount);
        //新增订单
        result = orderMapper.insertSelective(order);
        if (result>0){
            return WebResult.succcess("下单成功",order);
        }
        return WebResult.failed(ResultEnum.DATABASE_ERROR.getCode(),ResultEnum.DATABASE_ERROR.getMessage());
    }

    @Override
    public WebResult findOrder(Integer orderId) {
        Order order = orderMapper.selectByOrderId(orderId);
        return WebResult.succcess(ResultEnum.SUCCESS.getMessage(),order);
    }

    @Override
    public WebResult updateOrder(Order order) {
        Order order1 = orderMapper.selectByPrimaryKey(order.getOrderId());
        if (order1 == null){
            return WebResult.failed(ResultEnum.DATABASE_ERROR.getCode(),"订单不存在");
        }
        int result = orderMapper.updateByPrimaryKeySelective(order);
        if (result>0){
            return WebResult.succcess("操作成功",order);
        }
        return WebResult.failed(ResultEnum.DATABASE_ERROR.getCode(),ResultEnum.DATABASE_ERROR.getMessage());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public WebResult deleteOrder(Integer orderId) {
        Order order = orderMapper.selectByOrderId(orderId);
        if (order == null){
            return WebResult.failed(ResultEnum.DATABASE_ERROR.getCode(),"订单不存在");
        }
        //删除订单表示取消订单，那么用户账户中的余额要加回去
        UserAccount userAccount = userAccountMapper.selectByUserId(order.getUserId());
        Long newAccount = userAccount.getAccount() + order.getPayment();
        userAccount.setAccount(newAccount);
        int result = orderMapper.deleteByPrimaryKey(orderId);
        int result1 = 0;
        if (result>0){
            result1 = userAccountMapper.updateByPrimaryKey(userAccount);
        }
        if (result1 > 0){
            return WebResult.succcess("操作成功",order);
        }
        return WebResult.failed(ResultEnum.DATABASE_ERROR.getCode(),ResultEnum.DATABASE_ERROR.getMessage());
    }
}
