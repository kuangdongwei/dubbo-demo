package com.springbootdemos.luckymoney.dao;

import com.springbootdemos.luckymoney.model.TypeTest;

public interface TypeTestMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TypeTest record);

    int insertSelective(TypeTest record);

    TypeTest selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TypeTest record);

    int updateByPrimaryKey(TypeTest record);
}