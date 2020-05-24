package com.springbootdemos.luckymoney.service.impl;

import com.alibaba.fastjson.JSON;
import com.springbootdemos.luckymoney.dao.UserAccountMapper;
import com.springbootdemos.luckymoney.model.UserAccount;
import com.springbootdemos.luckymoney.service.UserAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserAccountServiceImplTest {
   @Resource
    private UserAccountService userAccountService;
   @Resource
   private UserAccountMapper accountMapper;
    @Test
    public void insertUserAccount() {
        UserAccount userAccount = new UserAccount();
        userAccount.setUserId(2323);
        userAccount.setUserName("jordan");
        userAccount.setAccount(new BigDecimal("6000000000.999").longValue());
        System.out.println(JSON.toJSON(userAccountService.insertUserAccount(userAccount)));
    }

    @Test
    public void findUserAccount() {
        System.out.println(JSON.toJSON(accountMapper.selectByUserId(222)));
    }

    @Test
    public void updateUserAccount() {
    }

    @Test
    public void deleteUserAccount() {
        System.out.println(JSON.toJSON(accountMapper.deleteByPrimaryKey(111)));
    }
}