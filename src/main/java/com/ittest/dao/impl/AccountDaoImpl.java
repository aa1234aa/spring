package com.ittest.dao.impl;

import com.ittest.dao.IAcountDao;
import org.springframework.stereotype.Repository;

/*账户的持久层实现类*/
@Repository("acountDao1")
public class AccountDaoImpl implements IAcountDao {
    public void saveAccount() {
        System.out.println("保存账户111111");
    }
}
