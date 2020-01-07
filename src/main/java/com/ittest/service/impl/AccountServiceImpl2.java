package com.ittest.service.impl;

import com.ittest.service.IAccountService;

import java.util.Date;

/*业务层实现类*/
public class AccountServiceImpl2 implements IAccountService {
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //private IAcountDao acountDao=new AccountDaoImpl();
    private String name;
    private Integer age;
    private Date date;

    public void saveAccount() {
        //acountDao.saveAccount();
        System.out.println(name+"..."+age+"..."+date);

    }




    /*   public void init() {
        System.out.println("初始化");

    }
    public void destory() {
        System.out.println("破坏");
    }*/
}
