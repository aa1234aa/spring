package com.ittest.service.impl;

import com.ittest.dao.IAcountDao;
import com.ittest.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*AutoWired 按照类型注入
* springioc是map结构<String  Object>

*   */

@Component(value = "accountService")
public class AccountServiceImpl3 implements IAccountService {
    @Autowired
  private IAcountDao acountDao;

    public void saveAccount() {
      acountDao.saveAccount();
    }
}
