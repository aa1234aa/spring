package com.ittest.service.impl;

import com.ittest.dao.IAcountDao;
import com.ittest.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
/*AutoWired 按照类型注入
* springioc是map结构<String  Object>

*   */

@Component(value = "accountService")
public class AccountServiceImpl3 implements IAccountService {
   /* 两个配合使用或者单独使用 @Resource
    @Autowired
    @Qualifier("acountDao1")
    value 用于注入基本类型和string类型的数据
    @scope()  singleton 单例   protitype多例    生命周期  preDestory销毁   PostContrust初始化
    */
   @Resource(name = "acountDao1")
  private IAcountDao acountDao=null;

    public void saveAccount() {
      acountDao.saveAccount();
    }
}
