package com.ittest.service.impl;

import com.ittest.service.IAccountService;
import org.springframework.stereotype.Component;

@Component(value = "accountService")
public class AccountServiceImpl3 implements IAccountService {

    public void saveAccount() {
        System.out.println("创建对象成功");
    }
}
