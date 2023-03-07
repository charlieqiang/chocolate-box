package cn.charlie.order.base.service;

import cn.charlie.order.base.reference.InventoryReference;
import cn.charlie.order.info.entity.OrderInfo;
import cn.charlie.order.info.entity.OrderParam;
import cn.charlie.order.base.mapper.OrderBaseMapper;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author charlie
 * @date 3/7/2023 9:15 AM
 **/
@Service
public class OrderBaseServiceImpl implements OrderBaseService {
    @Autowired
    private OrderBaseMapper orderBaseMapper;

    @Autowired
    private InventoryReference inventoryReference;

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
            return createOrderInfo(orderParam);
        } else {
            throw new Exception("下单接口: 库存扣减失败!");
        }
    }

    public OrderInfo createOrderInfo(OrderParam orderParam) throws Exception {
        int i = 1/0;
        OrderInfo orderInfo = buildOrderInfo(orderParam);
        int affectedRows = orderBaseMapper.insert(orderInfo);
        if (affectedRows > 0) {
            return orderInfo;
        } else {
            throw new Exception("下单接口: 订单创建失败!");
        }
    }

    private OrderInfo buildOrderInfo(OrderParam orderParam) {
        OrderInfo orderInfo = new OrderInfo();
        Long id = 7038399168028995584L;
        orderInfo.setId(id);
        orderInfo.setItemId(orderParam.getItemId());
        orderInfo.setCustomId(orderParam.getCustomId());
        orderInfo.setOrderQty(orderParam.getOrderQty());
        orderInfo.setOrderAmount(orderInfo.getOrderAmount());
        return orderInfo;
    }
}
