package com.springbootdemos.luckymoney.controller;

import com.google.gson.Gson;
import com.springbootdemos.luckymoney.model.PersonDto;
import org.junit.Test;

import java.lang.reflect.Type;

public class CopyTest {
    @Test
    public void copyTest(){
        PersonDto personDto = new PersonDto();
        personDto.setAge("24");
        personDto.setId("111");
        personDto.setName("Chandler");
        personDto.setSex("male");

        int testNumber = 123456;
        Gson gson = new Gson();
        System.out.println("自定义对象类型序列化为字符串："+gson.toJson(personDto));
        System.out.println("基本类型序列化为字符串："+ gson.toJson(testNumber));

//        String jsonString = "{\"id\":\"222\",\"name\":\"小菜鸡\",\"sex\":\"male\",\"age\":\"24\"}";
//        PersonDto personDto1 = gson.fromJson(jsonString,PersonDto.class);
//        System.out.println("personDto1的名字为："+personDto1.getName());
    }
}
