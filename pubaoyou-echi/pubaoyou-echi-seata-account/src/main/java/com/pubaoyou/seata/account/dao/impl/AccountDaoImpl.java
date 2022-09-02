package com.pubaoyou.seata.account.dao.impl;

import com.pubaoyou.seata.account.dao.AccountDao;
import com.pubaoyou.seata.account.mapper.ItsscAccountMapper;
import com.pubaoyou.seata.account.models.ItsscAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private ItsscAccountMapper itsscAccountMapper;

    @Override
    public void changeAccount(Map map) throws Exception {
        itsscAccountMapper.updateAccountNameById(map);
    }

    @Override
    public void changeAccount(ItsscAccount itsscAccount) throws Exception {
        itsscAccountMapper.updateByPrimaryKeySelective(itsscAccount);
    }


}
