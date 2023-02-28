package cn.charlie.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author charlie
 * @date 2/26/2023 12:47 AM
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("cn.charlie.member.info.mapper")
public class MemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class, args);
    }
}
