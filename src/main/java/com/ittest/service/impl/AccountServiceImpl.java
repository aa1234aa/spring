package com.ittest.service.impl;

import com.ittest.dao.IAcountDao;
import com.ittest.dao.impl.AccountDaoImpl;
import com.ittest.domain.Account;
import com.ittest.service.IAccountService;
import com.ittest.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*业务层实现类*/
public class AccountServiceImpl implements IAccountService {
    private TransactionManager txManger;

    public void setTxManger(TransactionManager txManger) {
        this.txManger = txManger;
    }

    public void setAcountDao(IAcountDao acountDao) {
        this.acountDao = acountDao;
    }

    private IAcountDao acountDao;
    @Override
    public List<Account> findAllAccount() {

        try {
            //开启事务
            txManger.beginTransaction();
            //执行操作
            List<Account> accounts=acountDao.findAllAccount();
            //提交事务
            txManger.commit();
            //返回结果
            return accounts;
        } catch (Exception e) {
            //回滚
            txManger.rollback();
            throw  new RuntimeException(e);
        } finally {
            //释放连接
            txManger.release();
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
        //开启事务
        txManger.beginTransaction();
        //执行操作
        Account account=acountDao.findAccountById(accountId);
        //提交事务
        txManger.commit();
        //返回结果
        return account;
    } catch (Exception e) {
        //回滚
        txManger.rollback();
        throw  new RuntimeException(e);
    } finally {
        //释放连接
        txManger.release();
    }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            //开启事务
            txManger.beginTransaction();
            //执行操作
           acountDao.saveAccount(account);
            //提交事务
            txManger.commit();
        } catch (Exception e) {
            //回滚
            txManger.rollback();
        } finally {
            //释放连接
            txManger.release();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            //开启事务
            txManger.beginTransaction();
            //执行操作
            acountDao.updateAccount(account);
            //提交事务
            txManger.commit();
        } catch (Exception e) {
            //回滚
            txManger.rollback();
        } finally {
            //释放连接
            txManger.release();
        }

    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            //开启事务
            txManger.beginTransaction();
            //执行操作
            acountDao.deleteAccount(accountId);
            //提交事务
            txManger.commit();
        } catch (Exception e) {
            //回滚
            txManger.rollback();
        } finally {
            //释放连接
            txManger.release();
        }

    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        try {
            //开启事务
            //txManger.beginTransaction();
            /*根据名称查，转入，转出账户减钱，转入账户加钱，更新转出账户，更新转入账户*/
            Account source=acountDao.findAccountByName(sourceName);
            Account target=acountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney()-money);
            target.setMoney(target.getMoney()+money);
            acountDao.updateAccount(source);
            acountDao.updateAccount(target);

            //提交事务
            //txManger.commit();
        } catch (Exception e) {
            //回滚
            //txManger.rollback();
        } finally {
            //释放连接
            //txManger.release();
        }

    }
}
