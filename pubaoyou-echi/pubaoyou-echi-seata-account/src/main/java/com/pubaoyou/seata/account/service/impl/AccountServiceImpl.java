package com.pubaoyou.seata.account.service.impl;

import com.pubaoyou.seata.account.dao.impl.AccountDaoImpl;
import com.pubaoyou.seata.account.service.AccountService;
import com.pubaoyou.seata.account.models.ItsscAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDaoImpl accountDao;

    @Override
    public void changeAccount(Map map) throws Exception {
        accountDao.changeAccount(map);
    }

    @Override
    public void changeAccount(ItsscAccount itsscAccount) throws Exception {
        accountDao.changeAccount(itsscAccount);
    }
}
