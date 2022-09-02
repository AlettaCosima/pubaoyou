package com.pubaoyou.test;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

@Slf4j
public class LambdaTest {

    public void routineTest(){
        //demo1
        List<String> strList = Arrays.asList("1","2","3","4");
        for(String str :strList){
            log.info("当前字符串为{}",str);
        }
    }

    public void lambdaTest(){
        List<String> strList = Arrays.asList("5","6","7","8");
        strList.forEach(x -> log.info("当前字符串为{}",x));
    }

    public void lambdavoidTest(String str){

        LambdaInterface lambdaInterface = (message) -> {
            log.info("hello,{}",str);
        };
    }

    public static void main(String[] args) {
        //new LambdaTest().lambdavoidTest("world");
        ResourceBundle bundle = java.util.ResourceBundle.getBundle("weixin/weixin");
        System.out.println(bundle.getString("appid"));

    }
}
