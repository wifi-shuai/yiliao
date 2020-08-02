package com.yiliao.health.exception;

/**
 * ClassName:LoginFailException
 * Package:com.atguigu.atcrowdfunding.exception
 * Description:
 *
 * @Date:2019/12/19 20:43
 * @Author:liangshuai@shuaige.com
 */
public class LoginFailException extends RuntimeException {
     public LoginFailException(String message){
         super(message);
     }
}
