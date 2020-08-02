package com.yiliao.health.bean;

/**
 * ClassName:Member
 * Package:com.yiliao.health.bean
 * Description:
 *
 * @Date:2020/4/30 9:21
 * @Author:liangshuai@shuaige.com
 */
public class Member {
    private Integer id;
    private String tel;
    private String password;
    private String username;
    private String authcode;
    private String email;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthcode() {
        return authcode;
    }

    public void setAuthcode(String authcode) {
        this.authcode = authcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
