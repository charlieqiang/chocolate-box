package cn.charlie.order.info.message.consumer;

import cn.charlie.order.info.entity.OrderInfo;
import cn.charlie.order.info.message.constant.OrderInfoMessageGroup;
import cn.charlie.order.info.message.constant.OrderInfoTopic;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;

/**
 * @author charlie
 * @date 3/10/2023 10:30 AM
 **/
@RocketMQMessageListener(
        topic = OrderInfoTopic.SYNC_ORDER_INFO,
        consumerGroup = OrderInfoMessageGroup.SYNC_ORDER_INFO_GROUP,
        selectorType = SelectorType.TAG,
        selectorExpression = "*",
        consumeMode = ConsumeMode.CONCURRENTLY,
        messageModel = MessageModel.CLUSTERING,
        consumeThreadMax = 64,
        consumeTimeout = 15L
)
public class OrderInfoSyncConsumer implements RocketMQListener<OrderInfo>{
    @Override
    public void onMessage(OrderInfo orderInfoMessage) {
        System.out.println("Receive message: " + orderInfoMessage + "  ThreadName: " + Thread.currentThread().getName());
    }
}
