package cn.charlie.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author charlie
 * @date 3/5/2023 10:30 PM
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("cn.charlie.member.*.mapper")
public class MemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class, args);
    }
}
