package com.springbootdemos.luckymoney.AOPprinciple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 静态代理实现案例：代理类
 */
public class SubjectProxy implements Subject{
    private Logger logger = LoggerFactory.getLogger(SubjectProxy.class);
    private RealSubject realSubject;

    public SubjectProxy(RealSubject realSubject){
        this.realSubject = realSubject;
    }
    @Override
    public void request(){
        logger.trace("proxy just do edge logic****** ");
        logger.trace("***before logic");
        realSubject.request();
        logger.trace("***after logic");
    }
}
