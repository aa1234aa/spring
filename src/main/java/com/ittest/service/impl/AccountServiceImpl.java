package com.ittest.service.impl;

import com.ittest.dao.IAcountDao;
import com.ittest.dao.impl.AccountDaoImpl;
import com.ittest.service.IAccountService;

import java.util.Date;

/*业务层实现类*/
public class AccountServiceImpl implements IAccountService {
    //private IAcountDao acountDao=new AccountDaoImpl();
    private String name;
    private Integer age;
    private Date date;

    public void saveAccount() {
        //acountDao.saveAccount();
        System.out.println(name+"..."+age+"..."+date);

    }

    public AccountServiceImpl(String name, Integer age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }


    /*   public void init() {
        System.out.println("初始化");

    }
    public void destory() {
        System.out.println("破坏");
    }*/
}
