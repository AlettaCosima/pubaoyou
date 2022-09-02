package com.pubaoyou.seata.account.service;

import com.pubaoyou.seata.account.models.ItsscAccount;

import java.util.Map;

public interface AccountService {

    public void changeAccount(Map map) throws Exception;

    public void changeAccount(ItsscAccount itsscAccount) throws Exception;
}
