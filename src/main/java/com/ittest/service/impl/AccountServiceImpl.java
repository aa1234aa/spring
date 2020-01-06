package com.ittest.service.impl;

import com.ittest.dao.IAcountDao;
import com.ittest.dao.impl.AccountDaoImpl;
import com.ittest.service.IAccountService;
/*业务层实现类*/
public class AccountServiceImpl implements IAccountService {
    private IAcountDao acountDao=new AccountDaoImpl();
    private int i=1;
    public void saveAccount() {
        acountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
