package com.example.springbootrabbitmqsimple.takeQueue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/4 10:24
 */
@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String sendMessage = "Hi, fanout msg";
        System.out.println("fanout message : " + sendMessage);
        this.rabbitTemplate.convertAndSend("fanoutExchange", "", sendMessage);
    }

}
