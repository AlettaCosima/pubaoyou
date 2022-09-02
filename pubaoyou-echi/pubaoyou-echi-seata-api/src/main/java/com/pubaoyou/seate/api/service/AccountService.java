package com.pubaoyou.seate.api.service;

import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(name = "pubaoyou-echi-seata-account")
public interface AccountService {

    @RequestMapping("/seata/account/v1/changeAccount")
    public String changeAccount(@RequestParam String xid) throws Exception;
}
