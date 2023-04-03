package cn.charlie.order;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author charlie
 * @date 3/5/2023 8:48 PM
 **/
@SpringCloudApplication
@MapperScan("cn.charlie.order.*.mapper")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
