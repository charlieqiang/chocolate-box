package cn.charlie.member.info.controller;

import cn.charlie.member.SpringServiceTest;
import cn.charlie.member.info.builder.MemberParamBuilder;
import cn.charlie.member.info.entity.MemberInfo;
import cn.charlie.member.info.entity.MemberInfoParam;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Map;

/**
 * @author charlie
 * @date 3/23/2023 8:37 AM
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MemberInfoControllerTest extends SpringServiceTest {

    @Test
    @Order(1)
    public void getAllMemberInfo() throws Exception {
        final Map<String, String> header = Maps.newHashMap();
        ResultActions resultActions = returnGetResultActions("/info", header);
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Order(2)
    public void addMemberByRedis() throws Exception {
        final Map<String, String> header = Maps.newHashMap();
        MemberInfoParam memberInfoParam = MemberParamBuilder.buildMemberInfoParam();
        ResultActions resultActions = returnPostResultActions("/info", memberInfoParam, header);
        String exp = "$.data.name";
        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(exp).value(memberInfoParam.getName()));
    }


    @Test
    @Order(3)
    public void getMemberNameByRedis() throws Exception {
        final Map<String, String> header = Maps.newHashMap();
        ResultActions resultActions = returnGetResultActions("/info/name", header);
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Order(4)
    public void createMemberInfoByEs() throws Exception {
        final Map<String, String> header = Maps.newHashMap();
        MemberInfo memberInfo = new MemberInfo();
        ResultActions resultActions = returnPostResultActions("/info/es", memberInfo, header);
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Order(5)
    public void getAllMemberInfoByEs() throws Exception {
        final Map<String, String> header = Maps.newHashMap();
        ResultActions resultActions = returnGetResultActions("/info/es", header);
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Order(6)
    public void addMemberInTransactionByRedis() throws Exception {
        final Map<String, String> header = Maps.newHashMap();
        MemberInfoParam memberInfoParam = MemberParamBuilder.buildMemberInfoParam();
        ResultActions resultActions = returnPostResultActions("/info/tx", memberInfoParam, header);
        String exp = "$.data.name";
        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(exp).value(memberInfoParam.getName()));
    }
}
