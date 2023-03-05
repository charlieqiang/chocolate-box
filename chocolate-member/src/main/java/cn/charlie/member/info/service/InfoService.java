package cn.charlie.member.info.service;

import cn.charlie.member.info.entity.Info;

import java.util.List;

/**
 * @author charlie
 * @date 3/5/2023 10:42 PM
 **/
public interface InfoService {

    /**
     * 获取全部成员信息
     *
     * @return 全部成员信息
     */
    List<Info> getAllMemberInfo();
}
