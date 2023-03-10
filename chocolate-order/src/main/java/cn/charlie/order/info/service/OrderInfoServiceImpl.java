package cn.charlie.order.info.service;

import cn.charlie.order.info.message.constant.OrderInfoTag;
import cn.charlie.order.info.message.constant.OrderInfoTopic;
import cn.charlie.order.info.message.producer.OrderInfoProducer;
import cn.charlie.order.info.reference.InventoryReference;
import cn.charlie.order.info.service.builder.OrderInfoBuilder;
import cn.charlie.order.info.entity.OrderInfo;
import cn.charlie.order.info.entity.OrderParam;
import cn.charlie.order.info.mapper.OrderInfoMapper;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author charlie
 * @date 3/7/2023 9:15 AM
 **/
@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private InventoryReference inventoryReference;

    @Autowired
    private OrderInfoProducer orderInfoProducer;

    @Override
    @GlobalTransactional
    public OrderInfo bookingOrder(OrderParam orderParam) throws Exception {
        if (ObjectUtils.isEmpty(orderParam)) {
            throw new Exception("下单接口: 订单参数不能为空!");
        }

        Long itemId = orderParam.getItemId();
        Integer operateQty = Math.negateExact(orderParam.getOrderQty());
        Boolean isDeducted = inventoryReference.operateInventoryByItemId(itemId, operateQty);

        if (isDeducted) {
            OrderInfo orderInfo = createOrderInfo(orderParam);
            orderInfoProducer.sendMessage("下单接口: 下单成功!", OrderInfoTopic.SYNC_ORDER_INFO, OrderInfoTag.ORDER_INFO_TAG);
            return orderInfo;
        } else {
            throw new Exception("下单接口: 库存扣减失败!");
        }
    }

    public OrderInfo createOrderInfo(OrderParam orderParam) throws Exception {
        OrderInfo orderInfo = OrderInfoBuilder.buildOrderInfo(orderParam);
        int affectedRows = orderInfoMapper.insert(orderInfo);
        if (affectedRows > 0) {
            return orderInfo;
        } else {
            throw new Exception("下单接口: 订单创建失败!");
        }
    }
}
