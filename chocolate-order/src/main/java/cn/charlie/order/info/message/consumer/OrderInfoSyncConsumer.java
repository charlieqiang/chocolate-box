package cn.charlie.order.info.message.consumer;

import cn.charlie.order.info.message.constant.OrderInfoMessageGroup;
import cn.charlie.order.info.message.constant.OrderInfoTopic;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;

/**
 * @author charlie
 * @date 3/10/2023 10:30 AM
 **/
@Component
@RocketMQMessageListener(
        topic = OrderInfoTopic.SYNC_ORDER_INFO,
        consumerGroup = OrderInfoMessageGroup.SYNC_ORDER_INFO_GROUP
)
public class OrderInfoSyncConsumer implements RocketMQListener<MessageExt>, RocketMQPushConsumerLifecycleListener {

    @Override
    public void onMessage(MessageExt messageExt) {
        String message = new String(messageExt.getBody(), StandardCharsets.UTF_8);
        System.out.println(MessageFormat.format("收到消息，topic:{0}, tag:{1}, msgId:{2}, body:{3}",
                messageExt.getTopic(),
                messageExt.getTags(),
                messageExt.getMsgId(),
                message));
    }

    @Override
    public void prepareStart(DefaultMQPushConsumer defaultMQPushConsumer) {
        defaultMQPushConsumer.setMaxReconsumeTimes(3);
        defaultMQPushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
    }
}
