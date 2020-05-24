package com.springbootdemos.luckymoney.model;

import lombok.Data;

@Data
public class PersonDto {
    //属性的命名一定要符合编程规范（驼峰命名）
    //不然@Requestbody在转换的时候就会失败
    private String id;
    private String name;
    private String sex;
    private String age;
}
