package cn.charlie.order.base.service;

import cn.charlie.order.info.entity.OrderInfo;
import cn.charlie.order.info.entity.OrderParam;

/**
 * @author charlie
 * @date 3/7/2023 9:14 AM
 **/
public interface OrderBaseService {
    /**
     * 下单接口
     *
     * @param orderParam 订单参数
     * @return 下单信息
     * @throws Exception 异常
     */
    OrderInfo bookingOrder(OrderParam orderParam) throws Exception;
}
