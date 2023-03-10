package cn.charlie.order.info.message.producer;


import org.apache.rocketmq.client.producer.SendResult;

public interface OrderInfoProducer {

    /**
     * 发送消息
     *
     * @param message 消息信息
     * @param topic   主题
     * @param tag     标签
     * @return 发送结果
     */
    SendResult sendMessage(Object message, String topic, String tag);
}
