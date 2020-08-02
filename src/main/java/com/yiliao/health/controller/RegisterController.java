package com.yiliao.health.controller;

import com.yiliao.health.bean.Member;
import com.yiliao.health.bean.User;
import com.yiliao.health.exception.LoginFailException;
import com.yiliao.health.service.MemberService;
import com.yiliao.health.service.UserService;
import com.yiliao.health.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * ClassName:RegisterController
 * Package:com.yiliao.health.controller
 * Description:
 *
 * @Date:2020/4/26 8:44
 * @Author:liangshuai@shuaige.com
 */
@RestController
public class RegisterController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private UserService userService;
    @Autowired
    JavaMailSenderImpl mailSender;

    @RequestMapping("/doRegister")
    public Object doRegister(Member member, HttpSession session) {
        AjaxResult result = new AjaxResult();

        try {
            String authcode = (String) session.getAttribute("authcode");
            String userAuthcode = member.getAuthcode();
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("tel", member.getTel());
            User userlogin = userService.queryDistinct(paramMap);
            if (userlogin == null && authcode.equals(userAuthcode)) {
                int count = memberService.saveMember(member);
                result.setSuccess(count == 1);
            }
            if (userlogin != null) {
                throw new LoginFailException("手机号已被使用，请重新输入！");
            }
            if (!authcode.equals(userAuthcode)) {
                throw new LoginFailException("验证码输入错误，请重新输入！");
            }
        } catch (Exception e) {
            result.setSuccess(false);
            e.printStackTrace();
            result.setMessage("注册失败!");
        }

        return result;
    }

    @RequestMapping("/getAuthcode")
    public void getAuthcode(HttpSession session, String email) {
        StringBuilder authcode = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            authcode.append(new Random().nextInt(10));
        }
        session.setAttribute("authcode", authcode.toString());
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setSubject("验证码审核");
            helper.setText(String.valueOf(authcode), true);
            helper.setTo(email);
            helper.setFrom("1733011220@qq.com");
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
