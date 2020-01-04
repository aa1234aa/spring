package com.ittest.dao.impl;

import com.ittest.dao.IAcountDao;
/*账户的持久层实现类*/
public class AccountDaoImpl implements IAcountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存账户");
    }
}
