package com.springbootdemos.luckymoney.service.impl;

import com.springbootdemos.luckymoney.common.ResultEnum;
import com.springbootdemos.luckymoney.common.WebResult;
import com.springbootdemos.luckymoney.dao.UserAccountMapper;
import com.springbootdemos.luckymoney.model.UserAccount;
import com.springbootdemos.luckymoney.service.UserAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Resource
    private UserAccountMapper accountMapper;

    @Override
    public WebResult insertUserAccount(UserAccount userAccount) {
        int result = accountMapper.insertSelective(userAccount);
        if (result>0){
            return WebResult.succcess("操作成功",userAccount);
        }
        return WebResult.failed(ResultEnum.DATABASE_ERROR.getCode(),ResultEnum.DATABASE_ERROR.getMessage());
    }

    @Override
    public WebResult findUserAccount(Integer userId) {
        UserAccount userAccount = accountMapper.selectByUserId(userId);
        return WebResult.succcess(ResultEnum.SUCCESS.getMessage(),userAccount);
    }


    @Override
    public WebResult updateUserAccount(UserAccount userAccount) {
        //先检查该账户是否存在
        UserAccount userAccount1 = accountMapper.selectByUserId(userAccount.getUserId());
        if (userAccount == null){
            return WebResult.failed(ResultEnum.DATABASE_ERROR.getCode(),"用户不存在");
        }
        int result = accountMapper.updateByPrimaryKeySelective(userAccount);
        if (result>0){
            return WebResult.succcess("操作成功",userAccount);
        }
        return WebResult.failed(ResultEnum.DATABASE_ERROR.getCode(),"更新失败");
    }

    @Override
    public WebResult deleteUserAccount(Integer userId) {
        //先检查该账户是否存在
        UserAccount userAccount = accountMapper.selectByUserId(userId);
        if (userAccount == null){
            return WebResult.failed(ResultEnum.DATABASE_ERROR.getCode(),"用户不存在");
        }
        int result = accountMapper.deleteByPrimaryKey(userId);
        if (result>0){
            return WebResult.succcess("操作成功",userAccount);
        }
        return WebResult.failed(ResultEnum.DATABASE_ERROR.getCode(),ResultEnum.DATABASE_ERROR.getMessage());
    }
}
