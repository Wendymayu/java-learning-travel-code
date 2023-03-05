package com.wendy.rabbitmq.simple;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @Description 这是原生rabbitMQ的生产者，未使用springboot的starter
 * @Author wendyma
 * @Date 2022/6/25 22:27
 * @Version 1.0
 */
public class Producer {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        //创建一个连接工厂,配置连接信息
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("175.24.68.139");
        //factory.setPort(15672);
        factory.setUsername("guest");
        factory.setPassword("guest");

        // 创建连接与通道
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            /**
             * 生成一个队列
             * 1.队列名称
             * 2.队列里面的消息是否持久化 默认消息存储在内存中
             * 3.该队列是否只供一个消费者进行消费 是否进行共享 true 可以多个消费者消费
             * 4.是否自动删除 最后一个消费者端开连接以后 该队列是否自动删除 true 自动删除
             * 5.其他参数
             */
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "hello world";
            /**
             * 发送一个消息
             * 1.发送到那个交换机
             * 2.路由的 key 是哪个  这里是队列名
             * 3.其他的参数信息
             * 4.发送消息的消息体
             */
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("消息发送完毕");
        }
    }
}
