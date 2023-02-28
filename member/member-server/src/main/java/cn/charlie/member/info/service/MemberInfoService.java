package cn.charlie.member.info.service;

import cn.charlie.member.info.entity.MemberInfo;

import java.util.List;

/**
 * @author charlie
 * @date 2/28/2023 4:17 PM
 **/
public interface MemberInfoService {
    /**
     * 获取全部成员信息
     *
     * @return 全部成员信息
     */
    List<MemberInfo> getAllMemberInfo();
}