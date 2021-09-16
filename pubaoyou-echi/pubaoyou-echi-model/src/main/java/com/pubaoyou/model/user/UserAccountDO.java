package com.pubaoyou.model.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: eric
 * @Date: 2021/7/8 16:11
 * @Version 1.0
 */
@Getter@Setter
public class UserAccountDO {
    /**
     * 用户ID
     */
    private String userID;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改时间
     */
    private Date updateDate;
    /**
     * 是否锁定
     */
    private boolean isLocked;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String mail;


}
