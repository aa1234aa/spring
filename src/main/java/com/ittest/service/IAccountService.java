package com.ittest.service;

import com.ittest.domain.Account;

import java.util.List;

/*
* 账户业务层的接口
* */
public interface IAccountService {
    /*查询所有*/
    List<Account> findAllAccount();
    /*查询一个*/
    Account findAccountById(Integer accountId);
    /*保存*/
    void saveAccount(Account account);
    /*更新*/
    void updateAccount(Account account);
    /*删除*/
    void deleteAccount(Integer accountId);
}
