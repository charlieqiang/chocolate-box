package cn.charlie.order.info.builder;

import cn.charlie.order.info.entity.OrderParam;

import java.math.BigDecimal;

/**
 * @author charlie
 * @date 3/22/2023 4:12 PM
 **/
public class OrderParamBuilder {
    public static OrderParam buildOrderParam() {
        OrderParam orderParam = new OrderParam();
        orderParam.setItemId(7038399168028995584L);
        orderParam.setCustomId(7038399168028995584L);
        orderParam.setOrderQty(1);
        orderParam.setOrderAmount(BigDecimal.ONE);
        return orderParam;
    }
}
