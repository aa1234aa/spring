package com.ittest.dao.impl;

import com.ittest.dao.IAcountDao;
import org.springframework.stereotype.Repository;

@Repository("acountDao2")
public class AccountDaoImpl2 implements IAcountDao {
    public void saveAccount() {
        System.out.println("保存账户22222");
    }
}
