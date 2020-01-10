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
}
