package com.yiliao.health.mapper;

import com.yiliao.health.bean.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

/**
 * ClassName:UserMapper
 * Package:com.yiliao.health.mapper
 * Description:
 *
 * @Date:2020/4/28 11:22
 * @Author:liangshuai@shuaige.com
 */

public interface UserMapper {
    @Select("select distinct tel, password from t_user where tel=#{tel} and password=#{password}")
    User queryUserlogin(Map<String, Object> paramMap);

    @Select("select distinct tel from t_user where tel=#{tel}")
    User queryDistinct(Map<String, Object> paramMap);

    @Select("select distinct tel from t_tel")
    String queryTel(String tel);

    @Update("update t_user set sign=#{sign} where tel=#{tel}")
    void saveSign(String sign,String tel);

    @Select("select username from t_user where tel=#{tel}")
    String showUsername(String tel);

    @Select("select sign from t_user where tel=#{tel}")
    String showSign(String tel);

    @Update("update t_user set username=#{username} where tel=#{tel}")
    void updateUsername(String username, String tel);

    @Update("update t_user set password=#{password} where tel=#{tel}")
    void updatePassword(String password, String tel);

    @Update("update t_user set email=#{email} where tel=#{tel}")
    void updateEmail(String email, String tel);

}
