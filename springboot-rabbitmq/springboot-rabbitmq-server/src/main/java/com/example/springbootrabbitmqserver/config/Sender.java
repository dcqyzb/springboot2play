package com.example.springbootrabbitmqserver.config;

import com.common.Commons;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/4 11:19
 */
@RestController
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @GetMapping("/send/{message}")
    public void send(@PathVariable String message) {
        System.out.println("send message: " + message);
        this.rabbitTemplate.convertAndSend(Commons.TEST_QUEUE_NAME, message);
    }
}
