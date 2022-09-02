package com.pubaoyou.dao.login.impl;

import com.pubaoyou.dao.login.LoginUserDao;
import com.pubaoyou.dao.mapper.ItsscAccountMapper;
import com.pubaoyou.dao.models.ItsscAccount;
import com.pubaoyou.dao.models.ItsscAccountExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class LoginUserDaoImpl implements LoginUserDao {

    @Autowired
    private ItsscAccountMapper itsscAccountMapper;

    @Override
    public List<ItsscAccount> queryUserAccount(String userName, String password) throws Exception {
        log.info("dao层传入用户名为{}，传入密码为{}",userName,password);
        ItsscAccountExample itsscAccountExample = new ItsscAccountExample();
        if(userName != null){
            itsscAccountExample.createCriteria().andUserNameEqualTo(userName);
        }
        if(password != null){
            itsscAccountExample.createCriteria().andUserNameEqualTo(password);
        }
        return itsscAccountMapper.selectByExample(itsscAccountExample);
    }

}
