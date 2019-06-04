package com.example.springbootrabbitmqcoutomer;

import com.common.Commons;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/4 11:17
 */
@Component
@RabbitListener(queues = Commons.TEST_QUEUE_NAME)
public class recover {

    @RabbitHandler
    public void getMessage(String message) {
        System.out.println("接收到信息：" + message);
    }
}
