package com.pubaoyou.wechat.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;


//@Configuration
//@RefreshScope
@Getter
@Setter
public class WechatConfig {

    @Value("${grant_type}")
    protected  String grant_type;

    @Value("${app_id}")
    protected  String appId;

    @Value("${app_secret}")
    protected  String appSecret;

}
