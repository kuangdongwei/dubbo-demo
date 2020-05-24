package com.springbootdemos.luckymoney.controller;

import org.junit.Test;

public class CopyTest {
    @Test
    public void copyTest(){
        int a = 1;
        int b = a;
        System.out.println("a="+a + " b="+b);
        a++;
        System.out.println("a="+a + " b="+b);


        Integer aa = 11;
        Integer bb = aa;
        System.out.println("aa=" + aa + " bb="+bb);
        aa++;
        System.out.println("aa=" + aa + " bb="+bb);

        StringBuilder haha = new StringBuilder("hello");
        StringBuilder xixi = haha;
        System.out.println("haha:"+haha+" xixi:"+xixi);
        haha.append("world");
        System.out.println("haha:"+haha+" xixi:"+xixi);
    }
}
