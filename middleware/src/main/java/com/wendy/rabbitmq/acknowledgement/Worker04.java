package com.wendy.rabbitmq.acknowledgement;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.wendy.rabbitmq.workqueue.RabbitMqUtils;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/6/26 14:32
 * @Version 1.0
 */
public class Worker04 {
    private static final String ACK_QUEUE_NAME = "ack_queue";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        System.out.println("C2 等待接收消息处理时间较长");
        //消息消费的时候如何处理消息
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody());
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                System.out.println("线程被中断");
            }
            System.out.println("接收到消息:" + message);
            /**
             * 1.消息标记 tag
             * 2.是否批量应答未应答消息
             */
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        };
        //采用手动应答
        boolean autoAck = false;
        channel.basicConsume(ACK_QUEUE_NAME, autoAck, deliverCallback, (consumerTag) -> {
            System.out.println(consumerTag + "消费者取消消费接口回调逻辑");
        });
    }
}
