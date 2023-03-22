package cn.charlie.customer.base;

import cn.charlie.customer.CustomerApplication;
import cn.charlie.customer.base.service.BaseService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author charlie
 * @date 3/22/2023 10:13 AM
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class serviceBaseServiceTest {
    @Autowired
    private BaseService baseService;

    @Test
    @Order(1)
    public void testBase(){
        String requestFoo = "hello Foo";
        String requestBar = "hello Bar";
        String requestAndy = "hello Andy";
        Assertions.assertEquals(baseService.echo(requestFoo), requestFoo);
        Assertions.assertEquals(baseService.echo(requestBar), requestBar);
        Assertions.assertEquals(baseService.echo(requestAndy), requestAndy);
    }
}
