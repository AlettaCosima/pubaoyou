package com.pubaoyou.seata.account.models;

public class ItsscAccount {
    private Integer id;

    private String userName;

    private String userPwd;

    private Integer type;

    private String remark;

    private String email;

    private String fsgDepartment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getFsgDepartment() {
        return fsgDepartment;
    }

    public void setFsgDepartment(String fsgDepartment) {
        this.fsgDepartment = fsgDepartment == null ? null : fsgDepartment.trim();
    }
}