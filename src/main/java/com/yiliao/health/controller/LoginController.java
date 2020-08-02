package com.yiliao.health.controller;

import com.yiliao.health.bean.User;
import com.yiliao.health.service.UserService;
import com.yiliao.health.util.AjaxResult;
import com.yiliao.health.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:LoginController
 * Package:com.yiliao.health.controller
 * Description:
 *
 * @Date:2020/4/28 11:02
 * @Author:liangshuai@shuaige.com
 */
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/doLogin")
    public Object doLogin(User user, HttpServletRequest request) {
        AjaxResult result = new AjaxResult();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("tel", user.getTel());
        paramMap.put("password", MD5Util.digest(user.getPassword()));
        User userlogin = userService.queryUserlogin(paramMap);
            if (userlogin == null) {
            result.setMessage("登录失败");
            result.setSuccess(false);
        }else {
            request.getSession().setAttribute("currentUser",userlogin);
            result.setSuccess(true);
        }

        return result;
    }
    @RequestMapping("/doSign")
    public void doSign(String sign,HttpServletRequest req){
        User user = (User)req.getSession().getAttribute("currentUser");
        String tel=user.getTel();
        userService.saveSign(sign, tel);
    }

    @RequestMapping("/showSign")
    public String showSign(HttpServletRequest req){
        User user = (User)req.getSession().getAttribute("currentUser");
        String tel=user.getTel();
        String s = userService.showSign(tel);
        return s;
    }
    @RequestMapping("/showUsername")
    public String showUsername(HttpServletRequest req){
        User user = (User)req.getSession().getAttribute("currentUser");
        String tel=user.getTel();
        String username = userService.showUsername(tel);

        return username;
    }
}

