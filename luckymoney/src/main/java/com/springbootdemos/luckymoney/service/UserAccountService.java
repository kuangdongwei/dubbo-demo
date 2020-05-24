package com.springbootdemos.luckymoney.service;

import com.springbootdemos.luckymoney.common.WebResult;
import com.springbootdemos.luckymoney.model.UserAccount;

public interface UserAccountService {
    /**
     * 新增账户记录
     * @param userAccount
     * @return
     */
    WebResult insertUserAccount(UserAccount userAccount);

    /**
     * 通过用户id查找账户
     * @param userId
     * @return
     */
    WebResult findUserAccount(Integer userId);

    /**
     * 更新账户信息
     * @param userAccount
     * @return
     */
    WebResult updateUserAccount(UserAccount userAccount);

    /**
     * 通过用户id删除账户
     * @param userId
     * @return
     */
    WebResult deleteUserAccount(Integer userId);
}
