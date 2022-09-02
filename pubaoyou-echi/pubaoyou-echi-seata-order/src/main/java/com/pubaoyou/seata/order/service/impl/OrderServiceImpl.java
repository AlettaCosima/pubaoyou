package com.pubaoyou.seata.order.service.impl;

import com.pubaoyou.seata.order.dao.impl.OrderDaoImpl;
import com.pubaoyou.seata.order.models.ItsscAccount;
import com.pubaoyou.seata.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDaoImpl orderDao;

    @Override
    public void changeOrder(ItsscAccount itsscAccount) throws Exception {
        orderDao.changeOrder(itsscAccount);
    }
}
