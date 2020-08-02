package com.yiliao.health.mapper;

import com.yiliao.health.bean.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


/**
 * ClassName:UploadMapper
 * Package:com.yiliao.health.mapper
 * Description:
 *
 * @Date:2020/5/3 11:50
 * @Author:liangshuai@shuaige.com
 */
public interface UploadMapper {
    @Update("update t_user set url=#{url} where tel=#{tel}")
    int saveUrl(String url, String tel);

    @Select("select url from t_user where tel=#{tel}")
    String showUrl(String tel);
}
