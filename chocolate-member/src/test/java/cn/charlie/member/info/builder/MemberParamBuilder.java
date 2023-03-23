package cn.charlie.member.info.builder;

import cn.charlie.member.info.entity.MemberInfoParam;

/**
 * @author charlie
 * @date 3/23/2023 10:16 AM
 **/
public class MemberParamBuilder {
    public static MemberInfoParam buildMemberInfoParam() {
        MemberInfoParam memberInfoParam = new MemberInfoParam();
        memberInfoParam.setName("charlie");
        return memberInfoParam;
    }
}
