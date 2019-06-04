package com.example.springbootrabbitmqsimple.workQueue;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/4 10:07
 */
@Component
@RabbitListener(queues = "neo")
public class NeoReceiver2 {
    @RabbitHandler
    public void process(String neo) {
        System.out.println("Receiver 2: " + neo);
    }
}
