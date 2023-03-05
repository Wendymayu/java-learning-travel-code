package com.wendy.rabbitmq.workqueue;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/6/25 23:32
 * @Version 1.0
 */
public class Worker01 {
    public static final String QUEUE_NAME = "hello";
    public static void main(String[] args) throws Exception {

        Channel channel = RabbitMqUtils.getChannel();
        System.out.println("C2等待接收消息");


        DeliverCallback deliverCallback = (var1, var2)->{
            System.out.println("接收到消息："+new String(var2.getBody()));
        };

        channel.basicConsume(QUEUE_NAME, true, deliverCallback, new CancelCallback() {
            @Override
            public void handle(String s) throws IOException {
                System.out.println("消费者取消接口回调");
            }
        });
    }
}
