package com.pubaoyou.seata.order.service;

import com.pubaoyou.seata.order.models.ItsscAccount;

public interface OrderService {

    public void changeOrder(ItsscAccount itsscAccount) throws Exception;
}
