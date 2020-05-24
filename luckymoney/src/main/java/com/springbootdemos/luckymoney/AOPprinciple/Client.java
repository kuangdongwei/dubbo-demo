package com.springbootdemos.luckymoney.AOPprinciple;

public class Client {
    public static void main(String[] args) {
        Subject subject = new SubjectProxy(new RealSubject());
        subject.request();
    }
}
