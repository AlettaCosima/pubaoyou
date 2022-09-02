package com.pubaoyou.website.controller;

import com.pubaoyou.utils.TipsUtils.TipsUtils;
import com.pubaoyou.website.constant.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;

@RequestMapping("/pubaoyou/echi/v1")
@RestController
@Slf4j
public class UserLoginController {


    @RequestMapping(value = "/prometheus_notice",method = RequestMethod.POST)
    public String prometheus_notice(@RequestBody byte[] data){
        String msg = new String(data, 0, data.length, Charset.forName("UTF-8"));
        log.info("接收AlertManager预警消息：" + msg);
        return "";
    }
    /**
     * main page for project
     * @return
     */
    @RequestMapping(value = "/toIndex",method = RequestMethod.GET)
    public ModelAndView toIndex(){
        log.info("do method index");
        return new ModelAndView("index");
    }

    /**
     * login page for project
     * @return
     */
    @RequestMapping(value = "/toLogin",method = RequestMethod.GET)
    public ModelAndView toLoginPage(){
        log.info("do method login");
        return new ModelAndView("login/login");
    }

    /**
     * method of login,use spring security
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toMain",method = RequestMethod.POST)
    public ModelAndView toMain(@RequestParam String userName, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) throws Exception{
        log.info("method toMain,params are username:{} and password:{}",userName,password);


        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
            TipsUtils.getInstance().pageTips(CommonConstant.RETURN_MESSAGE_LOGIN_FAILED,"用户名或密码为空");
        }
        request.setAttribute("userName",userName);
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public ModelAndView logout() throws Exception{
        log.info("do method logout");
        return new ModelAndView("index");
    }

}
