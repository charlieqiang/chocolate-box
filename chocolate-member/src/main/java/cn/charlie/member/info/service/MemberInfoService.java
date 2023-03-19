package cn.charlie.member.info.service;

import cn.charlie.member.info.entity.MemberInfo;
import cn.charlie.member.info.entity.MemberInfoParam;

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

    /**
     * 通过es获取全部成员信息
     *
     * @return 全部成员信息
     */
    List<MemberInfo> getAllMemberInfoByEs();

    /**
     * 通过es创建成员信息
     *
     * @return 成员信息
     * @param memberInfoParam
     */
    MemberInfo createMemberInfoByEs(MemberInfoParam memberInfoParam) throws Exception;

    /**
     * 添加成员姓名到Redis缓存
     *
     * @param name 姓名
     * @return 结果
     */
    String addMemberNameByRedis(String name) throws Exception;

    /**
     * 通过Redis查询成员姓名
     *
     * @return 结果
     */
    String getMemberNameByRedis();

    /**
     * 通过事务添加成员姓名到Redis缓存
     *
     * @param name 姓名
     * @return 结果
     */
    String addNameInTransactionByRedis(String name);
}
