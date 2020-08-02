package com.yiliao.health.service;

import com.yiliao.health.bean.User;
import com.yiliao.health.mapper.UserMapper;
import com.yiliao.health.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * ClassName:UserService
 * Package:com.yiliao.health.service
 * Description:
 *
 * @Date:2020/4/28 11:16
 * @Author:liangshuai@shuaige.com
 */
@Service
//@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryUserlogin(Map<String, Object> paramMap) {

        User user = userMapper.queryUserlogin(paramMap);

        return user;
    }

    public User queryDistinct(Map<String, Object> paramMap) {

        User user = userMapper.queryDistinct(paramMap);

        return user;
    }
    public String queryTel(String tel){
        return userMapper.queryTel(tel);
    }

    public void saveSign(String sign,String tel) {
        userMapper.saveSign(sign,tel);
    }

    public String showUsername(String tel) {
        return userMapper.showUsername(tel);
    }

    public String showSign(String tel) {
        return userMapper.showSign(tel);
    }

    public void updateUsername(String username, String tel) {
        userMapper.updateUsername(username,tel);
    }
    public void updateEmail(String email, String tel) {
        userMapper.updateEmail(email,tel);
    }
    public void updatePassword(String password, String tel) {
        String password1=MD5Util.digest(password);
        userMapper.updatePassword(password1,tel);
    }


}
