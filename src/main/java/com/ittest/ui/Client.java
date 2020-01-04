package com.ittest.ui;

import com.ittest.service.IAccountService;
import com.ittest.service.impl.AccountServiceImpl;
/*模拟一个表现层，用于调用业务层*/
public class Client {
    public static void main(String[] args) {
        IAccountService as=new AccountServiceImpl();
        as.saveAccount();
    }
}
