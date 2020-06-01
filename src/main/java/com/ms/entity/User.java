package com.ms.entity;

/**
 * @author ms_miao
 * @createTime 2020-06-01 10:25
 */
public class User {

    private Integer id;     //id
    private String username;//用户名
    private String password;//用户密码
    private String perms;   //用户所具有的权限

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
