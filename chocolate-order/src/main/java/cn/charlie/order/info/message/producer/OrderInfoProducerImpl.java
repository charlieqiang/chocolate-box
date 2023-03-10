package cn.charlie.order.info.message.producer;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

/**
 * @author charlie
 * @date 3/10/2023 10:59 AM
 **/
@Component
public class OrderInfoProducerImpl implements OrderInfoProducer {
    private final RocketMQTemplate rocketMqTemplate;

    public OrderInfoProducerImpl(RocketMQTemplate rocketMqTemplate) {
        this.rocketMqTemplate = rocketMqTemplate;
    }

    @Override
    public SendResult sendMessage(Object message, String topic, String tag) {
        try {
            final SendResult sendResult = this.rocketMqTemplate.syncSend(topic + ":" + tag, message);
            System.out.println("发送MQ成功：sendResult=" + sendResult + ",message=" + message.toString());
            return sendResult;
        } catch (Exception e) {
            System.out.println("消息发送失败, topic:" + topic + ",tag:" + tag + ", message:" + message + ", e: " + e);
        }
        return null;
    }
}
