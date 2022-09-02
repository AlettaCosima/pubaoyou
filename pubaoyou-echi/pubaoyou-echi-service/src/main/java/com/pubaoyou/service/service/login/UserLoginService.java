package com.pubaoyou.service.service.login;

import com.pubaoyou.dao.models.ItsscAccount;

import java.util.List;

/**
 * @Author: eric
 * @Date: 2021/7/8 16:29
 * @Version 1.0
 */
public interface UserLoginService {

    /**
     * 根据用户名密码查询账户信息
     * @return
     * @throws Exception
     */
    public List<ItsscAccount> queryUserAccount(String userName, String password) throws Exception;


    public ItsscAccount queryUserByName(String userName) throws Exception;


}
