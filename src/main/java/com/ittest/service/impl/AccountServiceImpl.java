package com.ittest.service.impl;

import com.ittest.dao.IAcountDao;
import com.ittest.dao.impl.AccountDaoImpl;
import com.ittest.service.IAccountService;
/*业务层实现类*/
public class AccountServiceImpl implements IAccountService {
    private IAcountDao acountDao=new AccountDaoImpl();

    public AccountServiceImpl() {
        System.out.println("创建对象");
    }

    public void saveAccount() {
        acountDao.saveAccount();

    }
    public void init() {
        System.out.println("初始化");

    }
    public void destory() {
        System.out.println("破坏");
    }
}
