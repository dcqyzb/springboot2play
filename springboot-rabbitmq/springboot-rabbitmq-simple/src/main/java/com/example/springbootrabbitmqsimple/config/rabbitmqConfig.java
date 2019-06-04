package com.example.springbootrabbitmqsimple.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/4 10:15
 */
@Configuration
public class rabbitmqConfig {

    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }

    @Bean
    public Queue Queue2() {
        return new Queue("neo");
    }

    /**
     * 发布订阅模式
     * 创建三个消息队列
     */

    @Bean
    public Queue AMessage() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B");
    }

    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C");
    }

    /**
     * 创建一个交换机
     */
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * 将队列绑定到交换机上
     */

    @Bean
    Binding bindingExchangeA(Queue AMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }

    /**
     * 主题模式
     * 新建两个队列
     */
    private final static String message = "topic.A";
    private final static String messages = "topic.B";

    @Bean
    public Queue queueMessage() {
        return new Queue(rabbitmqConfig.message);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(rabbitmqConfig.messages);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueMessage).to(topicExchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueMessages).to(topicExchange).with("topic.#");
    }

}
