package com.yiliao.health.service;


import com.yiliao.health.mapper.UploadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:UploadService
 * Package:com.yiliao.health.service
 * Description:
 *
 * @Date:2020/5/3 11:48
 * @Author:liangshuai@shuaige.com
 */
@Service
public class UploadService {
    @Autowired
    UploadMapper uploadMapper;
    public int saveUrl(String url, String tel){
        return uploadMapper.saveUrl(url,tel);
    }

    public String showUrl(String tel){
        return uploadMapper.showUrl(tel);
    }
}
