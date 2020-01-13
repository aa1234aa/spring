package com.ittest.dao;

import com.ittest.domain.Account;

import java.util.List;

/*账户的持久层接口*/
public interface IAcountDao {
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
    /*根据名称查询账户，有不是1个账户报异常*/
    Account findAccountByName(String accountName);
}
