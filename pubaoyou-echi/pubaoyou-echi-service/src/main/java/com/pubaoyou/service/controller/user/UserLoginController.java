package com.pubaoyou.service.controller.user;

import com.echi.model.user.UserAccountDO;
import com.google.gson.Gson;
import com.pubaoyou.service.controller.common.CommonController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Api("登录相关接口文档")
public class UserLoginController extends CommonController {

    @RequestMapping("/queryUserAccount")
    @ApiOperation(value = "查询用户",notes = "查询用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName",paramType = "query",value = "用户名",dataType = "String",example = "chentao"),
            @ApiImplicitParam(name = "password",paramType = "query",value = "密码",dataType = "String",example = "123456")
    })
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
