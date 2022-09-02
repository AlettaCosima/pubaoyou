package com.pubaoyou.seata.account.dao;

import com.pubaoyou.seata.account.models.ItsscAccount;

import java.util.Map;

public interface AccountDao {

    public void changeAccount(Map map) throws Exception;

    public void changeAccount(ItsscAccount itsscAccount) throws Exception;
}
