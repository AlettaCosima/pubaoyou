package com.pubaoyou.service.controller.user;

import com.echi.model.user.UserAccountDO;
import com.google.gson.Gson;
import com.pubaoyou.service.controller.common.CommonController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: eric
 * @Date: 2021/7/8 16:54
 * @Version 1.0
 */
@RestController
@RequestMapping("/service/user/login/v1")
public class UserLoginController extends CommonController {

    @RequestMapping("/queryUserAccount")
    public String queryUserAccount(@RequestParam String userName,@RequestParam String password){
        try {
            System.out.println("传入用户名为{}："+userName+"传入密码为{%}"+password);
            List<UserAccountDO> list = userLoginService.queryUserAccount(userName,password);
            return new Gson().toJson(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
