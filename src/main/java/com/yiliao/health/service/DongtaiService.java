package com.yiliao.health.service;

import com.yiliao.health.bean.DoDongTai;
import com.yiliao.health.bean.DongTai;
import com.yiliao.health.mapper.DongtaiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:DotaiService
 * Package:com.yiliao.health.service
 * Description:
 *
 * @Date:2020/5/11 16:06
 * @Author:liangshuai@shuaige.com
 */
@Service
public class DongtaiService {
    @Autowired
    DongtaiMapper dongtaiMapper;

    public int saveData(DoDongTai doDongTai) {
        return dongtaiMapper.saveData(doDongTai);
    }


    public List<DongTai> showData() {
        return dongtaiMapper.showData();
    }

    public void saveMessage(DoDongTai doDongTai) {
        dongtaiMapper.saveMessage(doDongTai);
    }
}
