package com.yiliao.health.controller;

import com.yiliao.health.bean.DoDongTai;
import com.yiliao.health.bean.DongTai;

import com.yiliao.health.bean.User;

import com.yiliao.health.service.DongtaiService;
import com.yiliao.health.service.UserService;
import com.yiliao.health.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * ClassName:DotaiController
 * Package:com.yiliao.health.controller
 * Description:
 *
 * @Date:2020/5/10 11:21
 * @Author:liangshuai@shuaige.com
 */
@RestController
public class DongtaiController {
    @Autowired
    private UserService userService;

    @Autowired
    private DongtaiService dongtaiService;
    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");


    @RequestMapping("/showData")
    public List<DongTai> showData() {
        return dongtaiService.showData();
    }

    @RequestMapping("/saveData")
    public Object importData(MultipartFile file, HttpServletRequest req, DoDongTai doDongTai) throws IOException {
        AjaxResult result = new AjaxResult();
        User user = (User) req.getSession().getAttribute("currentUser");
        doDongTai.setTel(user.getTel());
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
        String durl = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/upload" + format + newName;
        System.out.println(durl);
        req.getSession().setAttribute("durl1",durl);
        doDongTai.setDurl(durl);

        try {
            int count = dongtaiService.saveData(doDongTai);
            Integer id = doDongTai.getId();
            req.getSession().setAttribute("id",id);
            result.setSuccess(count == 1);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            e.printStackTrace();
            result.setMessage("上传失败!");
        }
        return result;

    }
    @RequestMapping("/saveMessage")
    public void saveMessage(DoDongTai doDongTai,HttpServletRequest req){
        Integer id = (int) req.getSession().getAttribute("id");
        doDongTai.setId(id);
        dongtaiService.saveMessage(doDongTai);
    }

}



