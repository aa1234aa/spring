package com.ittest.factory;

import com.ittest.service.IAccountService;
import com.ittest.service.impl.AccountServiceImpl;

/**
 * xx模块
 */
public class StaticFactory {
    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
