package com.example.springbootrabbitmqcoutomer.config;

import com.common.Commons;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/4 11:13
 */
@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue queueMessage() {
        return new Queue(Commons.TEST_QUEUE_NAME);
    }

}
