package com.example.springbootrabbitmqsimple.helloRabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author Mr.Deng
 * @description 消息生产者
 * @date 2019/6/4 9:55
 */
@Controller
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "Hello Rabbitmq";
        System.out.println("message : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }
}
