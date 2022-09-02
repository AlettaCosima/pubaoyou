package com.pubaoyou.wechat.config;


import com.alibaba.fastjson.JSONObject;
import com.pubaoyou.utils.HttpClient.HttpClientUtils;
import com.pubaoyou.utils.StringUtils;
import com.pubaoyou.wechat.constant.WechatUrlConstant;
import lombok.extern.slf4j.Slf4j;

/**
 * AccessToken的配置，根据实际情况调用
 */
@Slf4j
public class AccessTokenConfig {

    public static AccessTokenConfig instance;

    static {
        instance =  new AccessTokenConfig();
    }

    public AccessTokenConfig(){}

    public static AccessTokenConfig getInstance(){
        return instance;
    }

    private String accessToken = "";//全局的token，如失效会再次获取
    private static final int expires_in = 7200;//过期时间7200S

    /**
     * 获取腾讯的AccessToken
     * @return
     * @throws Exception
     */
    public String getAccessToken(String grant_type,String appId,String appSecret) throws Exception{

        if(StringUtils.isEmpty(accessToken)){
            refreshAccessToken(grant_type,appId,appSecret);
        }
        return accessToken;
    }

    public String refreshAccessToken(String grant_type,String appId,String appSecret) throws Exception{
        try {
            log.info("refreshAccessToken grant_type为:"+grant_type);
            String url = WechatUrlConstant.ACCESS_TOKEN_URL+"?"+"grant_type="+grant_type+"&appid="+appId+"&secret="+appSecret;
            log.info("refreshAccessToken url为:"+url);

            JSONObject json = HttpClientUtils.httpGet(url);

            if(json.get("access_token") != null){
                accessToken = json.get("access_token").toString();
            }
        } catch (Exception e) {
            log.error("[systemError]获取AccessToken异常：",e);
        }

        return accessToken;
    }


}
