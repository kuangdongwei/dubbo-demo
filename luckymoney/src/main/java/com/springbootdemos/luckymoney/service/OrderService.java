package com.springbootdemos.luckymoney.service;

import com.springbootdemos.luckymoney.common.WebResult;
import com.springbootdemos.luckymoney.model.Order;

public interface OrderService {
    /**
     * 新增订单记录
     * @param order
     * @return
     */
    WebResult insertOrder(Order order);

    /**
     * 通过订单id查找订单记录
     * @param orderId
     * @return
     */
    WebResult findOrder(Integer orderId);

    /**
     * 更新订单信息
     * @param order
     * @return
     */
    WebResult updateOrder(Order order);

    /**
     * 通过订单id删除订单
     * @param orderId
     * @return
     */
    WebResult deleteOrder(Integer orderId);
}
