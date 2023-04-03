package cn.charlie.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author charlie
 * @date 3/6/2023 10:06 PM
 **/
@SpringCloudApplication
@MapperScan("cn.charlie.storage.*.mapper")
public class StorageApplication {
    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class, args);
    }
}
