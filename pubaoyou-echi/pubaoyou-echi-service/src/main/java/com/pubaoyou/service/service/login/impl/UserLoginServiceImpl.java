package com.pubaoyou.service.service.login.impl;

import com.echi.model.user.UserAccountDO;
import com.pubaoyou.service.service.login.UserLoginService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: eric
 * @Date: 2021/7/8 16:33
 * @Version 1.0
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Override
    public List<UserAccountDO> queryUserAccount(String userName, String password) throws Exception {
        List<UserAccountDO> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserAccountDO userAccountDO = new UserAccountDO();
            userAccountDO.setUserID(String.valueOf(i));
            userAccountDO.setUserName("zhangsan"+i);
            userAccountDO.setPassword("zhangsanpw"+i);
            userAccountDO.setLocked(true);
            list.add(userAccountDO);
        }
        return list;
    }
}
