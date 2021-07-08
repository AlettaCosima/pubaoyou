package com.pubaoyou.service.service.login;

import com.echi.model.user.UserAccountDO;

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
    public List<UserAccountDO> queryUserAccount(String userName,String password) throws Exception;
}
