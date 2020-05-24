package com.springbootdemos.luckymoney.AOPprinciple;

/**
 * 代理模式实现案例：真实实现类
 */
public class RealSubject implements Subject{

    @Override
    public void request(){
        System.out.println("real subject execute here!");
    }
}
