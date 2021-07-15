package com.pubaoyou.service.controller.user;

import com.echi.model.user.UserAccountDO;
import com.google.gson.Gson;
import com.pubaoyou.service.controller.common.CommonController;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * @Author: eric
 * @Date: 2021/7/8 16:54
 * @Version 1.0
 */
@RestController
@RequestMapping("/service/user/login/v1")
@Slf4j
public class UserLoginController extends CommonController {

    @RequestMapping("/queryUserAccount")
    public String queryUserAccount(@RequestParam String userName,@RequestParam String password){
        try {
            log.info("传入用户名为{}，传入密码为{}",userName,password);
            List<UserAccountDO> list = userLoginService.queryUserAccount(userName,password);
            return new Gson().toJson(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
