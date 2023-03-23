package cn.charlie.member.info.builder;

import cn.charlie.common.entity.snowflakeid.SnowflakeIdWorker;
import cn.charlie.member.info.entity.MemberInfo;
import cn.charlie.member.info.entity.MemberInfoParam;
import org.springframework.util.ObjectUtils;

/**
 * @author charlie
 * @date 3/23/2023 10:11 AM
 **/
public class MemberInfoBuilder {
    public static MemberInfo buildMemberInfo(MemberInfoParam memberInfoParam) throws Exception {
        MemberInfo memberInfo = new MemberInfo();
        if (ObjectUtils.isEmpty(memberInfoParam)) {
            throw new Exception("用户创建失败: 参数不能为空!");
        }
        long id = SnowflakeIdWorker.getInstance().nextId();
        memberInfo.setId(id);
        memberInfo.setName(memberInfoParam.getName());
        memberInfo.setSex(memberInfoParam.getSex());
        memberInfo.setAge(memberInfoParam.getAge());
        return memberInfo;
    }
}
