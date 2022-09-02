package com.pubaoyou.seata.order.controller;

import com.pubaoyou.seata.order.service.impl.OrderServiceImpl;
import com.pubaoyou.seata.order.models.ItsscAccount;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/seata/order/v1/")
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping(value = "/changeOrder")
    public String changeOrder(String xid) throws Exception{
        log.info("order XID " + xid);
        RootContext.bind(xid);
        long s = Long.valueOf("s");
        ItsscAccount itsscAccount = new ItsscAccount();
        itsscAccount.setId(6);
        itsscAccount.setUserPwd("1234");
        orderService.changeOrder(itsscAccount);
        return "hello world seata order";
    }
}
