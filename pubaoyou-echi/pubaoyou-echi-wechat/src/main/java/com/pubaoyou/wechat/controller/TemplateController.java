package com.pubaoyou.wechat.controller;

import com.alibaba.fastjson.JSONObject;
import com.pubaoyou.utils.HttpClient.HttpClientUtils;
import com.pubaoyou.wechat.constant.TemplateConstant;
import com.pubaoyou.wechat.constant.WechatUrlConstant;
import com.pubaoyou.wechat.config.AccessTokenConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wechat/template/v1")
@Slf4j
@RefreshScope
public class TemplateController {

    @Value("${grant_type}")
    protected  String grant_type;

    @Value("${app_id}")
    protected  String appId;

    @Value("${app_secret}")
    protected  String appSecret;

    /**
     * 模板推送测试接口
     * @return
     * @throws Exception
     */
    @RequestMapping("/pushTemplateForPhysical")
    public String pushTemplateForPhysical() throws Exception{
        try {
            String accesstoken = AccessTokenConfig.getInstance().getAccessToken(grant_type,appId,appSecret);

            log.info("当前accesstoken为："+accesstoken);

            Map map = new HashMap();
            map.put("touser","oyvETt_i6ULfqPN2jv2M2kTnzI6k");//openID
            map.put("template_id", TemplateConstant.TEMPLATE_SALARY_ID);
            map.put("url","https://mptest.fsgplus.com/sfsctechWechat/efesco/employeeBenefitsController.do?goEmployeeBenefits=&displaytitle=2");
            map.put("appid",appId);
            Map dataMap = new HashMap();

            Map firstmap = new HashMap();
            firstmap.put("value","10");
            dataMap.put("first",firstmap);

            Map keyword1 = new HashMap();
            keyword1.put("value","10");
            dataMap.put("keyword1",keyword1);

            Map keyword2 = new HashMap();
            keyword2.put("value","10");
            dataMap.put("keyword2",keyword2);

            Map keyword3 = new HashMap();
            keyword3.put("value","10");
            dataMap.put("keyword3",keyword3);

            Map remark = new HashMap();
            remark.put("value","工资发放明细");
            dataMap.put("remark",remark);

            map.put("data",dataMap);
            JSONObject mapJson = new JSONObject(map);

            log.info(mapJson.toJSONString());


            JSONObject json = HttpClientUtils.httpPost(WechatUrlConstant.ACCESS_TEMPLATE_URL+accesstoken,mapJson);

            log.info(json.toJSONString());

            return accesstoken;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "获取token失败";
    }

}
