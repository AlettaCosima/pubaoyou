package com.pubaoyou.seata.order.dao.impl;

import com.pubaoyou.seata.order.dao.OrderDao;
import com.pubaoyou.seata.order.mapper.ItsscAccountMapper;
import com.pubaoyou.seata.order.models.ItsscAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private ItsscAccountMapper itsscAccountMapper;

    @Override
    public void changeOrder(ItsscAccount itsscAccount) throws Exception {

        itsscAccountMapper.updateByPrimaryKeySelective(itsscAccount);

    }
}
