package cn.charlie.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author charlie
 * @date 3/5/2023 8:48 PM
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("cn.charlie.order.*.mapper")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
