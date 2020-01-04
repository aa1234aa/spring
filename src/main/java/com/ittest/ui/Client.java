package com.ittest.ui;

import com.ittest.factory.BeanFactory;
import com.ittest.service.IAccountService;
/*模拟一个表现层，用于调用业务层*/
public class Client {
    public static void main(String[] args) {
       // IAccountService as=new AccountServiceImpl();
        IAccountService as= (IAccountService) BeanFactory.getBean("accountService");
        as.saveAccount();
    }
}
