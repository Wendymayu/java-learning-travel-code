package com.wendy.rabbitmq.spring.controller;


import com.wendy.rabbitmq.spring.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/5/17 21:58
 * @Version 1.0
 */
@RestController
@RequestMapping("/")
public class ProduceController {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @PostMapping("order")
    public String order() {
        System.out.println("开始调用库存管理服务");

        String message = "send email message to user";
        /**
         * 参数：
         * 1、交换机名称
         * 2、routingKey
         * 3、消息内容
         */
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_TOPICS_INFORM, "inform.email", message);
        return "order success";
    }
}
