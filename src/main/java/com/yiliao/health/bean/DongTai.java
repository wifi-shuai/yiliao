package com.yiliao.health.bean;

/**
 * ClassName:DongTai
 * Package:com.yiliao.health.bean
 * Description:
 *
 * @Date:2020/5/11 16:32
 * @Author:liangshuai@shuaige.com
 */
public class DongTai {
    private String username;
    private String url;
    private String message;
    private String durl;
    private String sign;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDurl() {
        return durl;
    }

    public void setDurl(String durl) {
        this.durl = durl;
    }
}
