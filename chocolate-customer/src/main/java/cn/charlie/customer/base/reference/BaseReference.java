package cn.charlie.customer.base.reference;

import cn.charlie.common.dubbo.api.base.BaseClient;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author charlie
 * @date 3/5/2023 9:49 PM
 **/
@Service
public class BaseReference {

    @Reference
    private BaseClient baseClient;

    public String echo(String str) {
        return baseClient.echo(str);
    }

}
