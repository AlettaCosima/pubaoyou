package com.pubaoyou.seate.api.controller;


import com.pubaoyou.seate.api.service.OrderService;
import com.pubaoyou.seate.api.service.AccountService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/seata/api/v1/")
@RestController
@Slf4j
public class ApiController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/changeAccountOrder")
    @GlobalTransactional
    public String changeAccountOrder() throws Exception{
        String xid = RootContext.getXID();
        log.info("current XID: {}",xid);
        String accountMsg = accountService.changeAccount(xid);
        String orderMsg = orderService.changeOrder(xid);
        return accountMsg+orderMsg;
    }

}
