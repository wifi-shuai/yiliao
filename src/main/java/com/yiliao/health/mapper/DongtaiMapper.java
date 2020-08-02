package com.yiliao.health.mapper;

import com.yiliao.health.bean.DoDongTai;
import com.yiliao.health.bean.DongTai;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * ClassName:DotaiMapper
 * Package:com.yiliao.health.mapper
 * Description:
 *
 * @Date:2020/5/11 16:06
 * @Author:liangshuai@shuaige.com
 */

public interface DongtaiMapper {


    @Insert("insert into t_dongtai(id,tel,durl) values(#{id},#{tel},#{durl})")
    @Options(useGeneratedKeys = true,keyProperty ="id")
    int saveData(DoDongTai doDongTai);

    @Select("select DISTINCT t_user.username,t_user.url,t_dongtai.message,t_dongtai.durl,t_user.sign from t_dongtai,t_user where t_user.tel=t_dongtai.tel")
    List<DongTai> showData();

    @Update("update t_dongtai set message=#{message} where id=#{id}")
    void saveMessage(DoDongTai doDongTai);
}
