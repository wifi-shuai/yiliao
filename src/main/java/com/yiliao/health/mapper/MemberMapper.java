package com.yiliao.health.mapper;

import com.yiliao.health.bean.Member;
import org.apache.ibatis.annotations.Insert;

/**
 * ClassName:memberMapper
 * Package:com.yiliao.health.mapper
 * Description:
 *
 * @Date:2020/4/30 15:22
 * @Author:liangshuai@shuaige.com
 */
public interface MemberMapper {
    @Insert("insert into t_user(tel,password,username,email) values(#{tel},#{password},#{username},#{email})")
    public int saveMember(Member member);

}
