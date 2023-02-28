package cn.charlie.member.login.controller;

import cn.charlie.member.SpringServiceTest;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.core.annotation.Order;

import java.util.Map;

/**
 * @author charlie
 * @date 2/28/2023 12:36 PM
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginControllerTest extends SpringServiceTest {

    @Test
    @Order(1)
    public void getSession() throws Exception {
        final Map<String, String> header = Maps.newHashMap();
        String mvcResult = returnGetResponseContent("/session", header);
        LOGGER.info(mvcResult);
    }
}
