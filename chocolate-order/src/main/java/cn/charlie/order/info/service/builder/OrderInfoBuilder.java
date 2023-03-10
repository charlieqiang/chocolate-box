package cn.charlie.order.info.service.builder;

import cn.charlie.common.entity.snowflakeid.SnowflakeIdWorker;
import cn.charlie.order.info.entity.OrderInfo;
import cn.charlie.order.info.entity.OrderParam;

/**
 * @author charlie
 * @date 3/10/2023 10:02 AM
 **/
public class OrderInfoBuilder {

    public static OrderInfo buildOrderInfo(OrderParam orderParam) {
        OrderInfo orderInfo = new OrderInfo();
        Long id = SnowflakeIdWorker.getInstance().nextId();
        orderInfo.setId(id);
        orderInfo.setItemId(orderParam.getItemId());
        orderInfo.setCustomId(orderParam.getCustomId());
        orderInfo.setOrderQty(orderParam.getOrderQty());
        orderInfo.setOrderAmount(orderInfo.getOrderAmount());
        return orderInfo;
    }
}
