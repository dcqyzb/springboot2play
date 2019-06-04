package com.example.springbootrabbitmqsimple.topicQueue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/4 10:57
 */
@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String sendMessage = "Hi, i am message all";
        System.out.println("sender message 1:" + sendMessage);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.1", sendMessage);
    }

    public void send1() {
        String sendMessage = "Hi, i am message 1";
        System.out.println("sender message :" + sendMessage);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", sendMessage);
    }

    public void send2() {
        String sendMessage = "Hi, i am message 2";
        System.out.println("sender message:" + sendMessage);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", sendMessage);
    }
}
