package com.example.springbootrabbitmqsimple.takeQueue;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/4 10:27
 */
@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiveA {

    @RabbitHandler
    public void process(String message) {
        System.out.println("fanout.A : " + message);
    }
}
