package com.ittest.service.impl;

import com.ittest.dao.IAcountDao;
import com.ittest.dao.impl.AccountDaoImpl;
import com.ittest.domain.Account;
import com.ittest.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*业务层实现类*/
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    public void setAcountDao(IAcountDao acountDao) {
        this.acountDao = acountDao;
    }

    private IAcountDao acountDao;
    @Override
    public List<Account> findAllAccount() {
        return acountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return acountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
     acountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
     acountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer accountId) {
    acountDao.deleteAccount(accountId);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        /*根据名称查，转入，转出账户减钱，转入账户加钱，更新转出账户，更新转入账户*/
        Account source=acountDao.findAccountByName(sourceName);
        Account target=acountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);
        acountDao.updateAccount(source);
        acountDao.updateAccount(target);

    }
}
