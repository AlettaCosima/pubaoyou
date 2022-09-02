package com.pubaoyou.seata.account.mapper;

import com.pubaoyou.seata.account.models.ItsscAccount;
import com.pubaoyou.seata.account.models.ItsscAccountExample;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ItsscAccountMapper {

    List<ItsscAccount> selectByExample(ItsscAccountExample example);

    void updateByPrimaryKeySelective(ItsscAccount itsscAccount);

    void updateByExampleSelective(Map map);

    void updateAccountNameById(Map map);

}