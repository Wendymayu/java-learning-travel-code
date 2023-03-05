package com.wendy.rabbitmq.workqueue;

import com.rabbitmq.client.Channel;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/6/25 23:47
 * @Version 1.0
 */
public class Producer {
    private static final String QUEUE_NAME="hello";
    public static void main(String[] args) throws Exception {
        try(Channel channel=RabbitMqUtils.getChannel();) {
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            //从控制台当中接受信息
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()){
                String message = scanner.next();
                channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
                System.out.println("发送消息完成:"+message);
            }
        }
    }
}
