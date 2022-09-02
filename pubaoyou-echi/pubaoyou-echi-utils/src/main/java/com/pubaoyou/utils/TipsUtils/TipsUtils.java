package com.pubaoyou.utils.TipsUtils;

import com.alibaba.fastjson.JSONObject;
import com.pubaoyou.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 页面返回提示类，用于封装页面提示
 */
@Slf4j
public class TipsUtils {

    private static TipsUtils instance = new TipsUtils();


    public TipsUtils(){

    }

    public static TipsUtils getInstance(){
        return  instance;
    }

    public String pageTips(String returnCode,String returnMsg) throws Exception{

        Map map = new HashMap();

        try {
            log.info("当前传入参数为{%s,%s}",returnCode,returnMsg);
            if (StringUtils.isEmpty(returnCode) || StringUtils.isEmpty(returnMsg)){
                return null;
            }
            map.put("returnCode",returnCode);
            map.put("returnMsg",returnMsg);

        } catch (Exception e) {
            log.info("解析异常，请联系管理员");
            e.printStackTrace();
        }

        return JSONObject.toJSON(map).toString();
    }

}
