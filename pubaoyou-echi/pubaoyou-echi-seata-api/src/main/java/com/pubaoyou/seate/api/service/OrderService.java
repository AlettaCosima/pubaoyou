package com.pubaoyou.seate.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(name = "pubaoyou-echi-seata-order")
public interface OrderService {

    @RequestMapping(value = "/seata/order/v1/changeOrder")
    public String changeOrder(@RequestParam String xid) throws Exception;
}
