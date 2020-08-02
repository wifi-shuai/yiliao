package com.yiliao.health.controller;

import com.yiliao.health.bean.Health;
import com.yiliao.health.bean.User;
import com.yiliao.health.service.HealthService;
import com.yiliao.health.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * ClassName:HealthController
 * Package:com.yiliao.health.controller
 * Description:
 *
 * @Date:2020/5/2 9:04
 * @Author:liangshuai@shuaige.com
 */
@RestController
public class HealthController {
    @Autowired
    HealthService healthService;

    @Autowired
    UserService userService;
    @RequestMapping("/showHealth")
    public String showHealth(Health health,HttpSession session){
        User user = (User)session.getAttribute("currentUser");
        String username = userService.showUsername(user.getTel());
        return healthService.showHealth(health,username);
    }
}
