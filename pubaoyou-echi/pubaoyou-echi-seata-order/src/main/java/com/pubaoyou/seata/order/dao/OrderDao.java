package com.pubaoyou.seata.order.dao;

import com.pubaoyou.seata.order.models.ItsscAccount;

public interface OrderDao {

    public void changeOrder(ItsscAccount itsscAccount) throws Exception;
}
