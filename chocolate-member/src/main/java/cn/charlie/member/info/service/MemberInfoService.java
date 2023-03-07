package cn.charlie.member.info.service;

import cn.charlie.member.info.entity.MemberInfo;

import java.util.List;

/**
 * @author charlie
 * @date 3/5/2023 10:42 PM
 **/
public interface MemberInfoService {

    /**
     * 获取全部成员信息
     *
     * @return 全部成员信息
     */
    List<MemberInfo> getAllMemberInfo();
}
