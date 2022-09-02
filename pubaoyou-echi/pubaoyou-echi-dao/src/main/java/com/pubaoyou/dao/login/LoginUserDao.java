package com.pubaoyou.dao.login;

import com.pubaoyou.dao.models.ItsscAccount;

import java.util.List;

public interface LoginUserDao {

    /**
     * 根据用户名密码查询账户信息
     * @return
     * @throws Exception
     */
    public List<ItsscAccount> queryUserAccount(String userName, String password) throws Exception;

}
