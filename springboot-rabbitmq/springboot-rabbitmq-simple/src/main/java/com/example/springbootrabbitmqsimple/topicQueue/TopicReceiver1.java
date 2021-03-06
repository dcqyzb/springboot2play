package com.example.springbootrabbitmqsimple.topicQueue;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/4 11:02
 */
@Component
@RabbitListener(queues = "topic.B")
public class TopicReceiver1 {

    @RabbitHandler
    public void process(String message) {
        System.out.println("topic receiver 2:" + message);
    }
}
