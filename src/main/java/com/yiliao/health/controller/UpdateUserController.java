package com.yiliao.health.controller;

import com.yiliao.health.bean.User;
import com.yiliao.health.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName:UpdateUserController
 * Package:com.yiliao.health.controller
 * Description:
 *
 * @Date:2020/5/5 11:57
 * @Author:liangshuai@shuaige.com
 */
@RestController
public class UpdateUserController{
    @Autowired
    private UserService userService;
    @RequestMapping("/updateUsername")
    public void updateUsername(HttpServletRequest req,String username){
        User user = (User)req.getSession().getAttribute("currentUser");
        userService.updateUsername(username,user.getTel());
    }
    @RequestMapping("/updatePassword")
    public void updatePassword(HttpServletRequest req,String password){
        User user = (User)req.getSession().getAttribute("currentUser");
        userService.updatePassword(password,user.getTel());
    }
    @RequestMapping("/updateEmail")
    public void updateEmail(HttpServletRequest req,String email){
        User user = (User)req.getSession().getAttribute("currentUser");
        userService.updateEmail(email,user.getTel());
    }
}
