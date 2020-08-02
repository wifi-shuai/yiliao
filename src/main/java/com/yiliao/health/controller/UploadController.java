package com.yiliao.health.controller;

import com.yiliao.health.bean.User;

import com.yiliao.health.service.UploadService;
import com.yiliao.health.service.UserService;
import com.yiliao.health.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * ClassName:UploadController
 * Package:com.yiliao.health.controller
 * Description:
 *
 * @Date:2020/5/3 11:53
 * @Author:liangshuai@shuaige.com
 */
@RestController
public class UploadController {
    @Autowired
    UserService userService;
    @Autowired
    UploadService uploadService;
    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");

    @RequestMapping("/upload")
    public Object importData(MultipartFile file, HttpServletRequest req) throws IOException {
        AjaxResult result = new AjaxResult();
        User user = (User)req.getSession().getAttribute("currentUser");
        String format = sdf.format(new Date());
        String realPath = req.getServletContext().getRealPath("/upload") + format;
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        byte[] bytes = oldName.getBytes("ISO8859-1");
        oldName = new String(bytes, "UTF-8");
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        File file1 = new File(folder, newName);
        file.transferTo(file1);
        String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/upload" + format + newName;

        try {
            int count = uploadService.saveUrl(url, user.getTel());
            result.setSuccess(count == 1);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            e.printStackTrace();
            result.setMessage("上传失败!");
        }
        return result;

    }

    @RequestMapping("/show")
    public String showData(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("currentUser");
        System.out.println(user.getTel());
        String url = uploadService.showUrl(user.getTel());
        return url;
    }
}
