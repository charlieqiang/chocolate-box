package cn.charlie.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author charlie
 * @date 3/6/2023 10:06 PM
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("cn.charlie.storage.*.mapper")
public class StorageApplication {
    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class, args);
    }
}
