package cn.charlie.order.dubbo;

import cn.charlie.common.dubbo.api.base.BaseClient;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author charlie
 * @date 3/5/2023 8:44 PM
 **/
@Service
public class BaseServiceImpl implements BaseClient {
    @Override
    public String echo(String str) {
        System.out.println(str);
        return str;
    }
}
