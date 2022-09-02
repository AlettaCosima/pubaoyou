package com.pubaoyou.seata.account.controller;

import com.pubaoyou.seata.account.service.impl.AccountServiceImpl;
import com.pubaoyou.seata.account.models.ItsscAccount;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/seata/account/v1/")
@RestController
@Slf4j
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @GetMapping(value = "/changeAccount")
    public String changeAccount(String xid) throws Exception{
        log.info("account XID " + xid);
        RootContext.bind(xid);
        ItsscAccount itsscAccount = new ItsscAccount();
        itsscAccount.setId(5);
        itsscAccount.setUserPwd("123456");
        accountService.changeAccount(itsscAccount);


        return "hello seata account!!!";
    }

}
