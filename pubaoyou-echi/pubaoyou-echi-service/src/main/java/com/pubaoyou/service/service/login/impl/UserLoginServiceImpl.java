package com.pubaoyou.service.service.login.impl;

import com.pubaoyou.dao.login.impl.LoginUserDaoImpl;
import com.pubaoyou.dao.models.ItsscAccount;
import com.pubaoyou.service.service.login.UserLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author: eric
 * @Date: 2021/7/8 16:33
 * @Version 1.0
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Resource
    private LoginUserDaoImpl loginUserDao;

    @Override
    public List<ItsscAccount> queryUserAccount(String userName, String password) throws Exception {
        List<ItsscAccount> list =  loginUserDao.queryUserAccount(userName,password);
        return list;
    }

    @Override
    public ItsscAccount queryUserByName(String userName) throws Exception {
        return null;
    }
}
