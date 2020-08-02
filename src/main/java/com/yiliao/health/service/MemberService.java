package com.yiliao.health.service;

import com.yiliao.health.bean.Member;
import com.yiliao.health.mapper.MemberMapper;
import com.yiliao.health.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:memberService
 * Package:com.yiliao.health.service
 * Description:
 *
 * @Date:2020/4/30 15:19
 * @Author:liangshuai@shuaige.com
 */
@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;
    public int saveMember(Member member) {
        member.setPassword(MD5Util.digest(member.getPassword()));
        return memberMapper.saveMember(member);
    }
}
