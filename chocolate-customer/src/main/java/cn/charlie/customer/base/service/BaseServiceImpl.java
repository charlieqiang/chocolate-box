package cn.charlie.customer.base.service;

import cn.charlie.customer.base.reference.BaseReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author charlie
 * @date 3/5/2023 9:46 PM
 **/
@Service
public class BaseServiceImpl implements BaseService{
    @Autowired
    private BaseReference baseReference;

    @Override
    public String echo(String str) {
        return baseReference.echo(str);
    }
}
