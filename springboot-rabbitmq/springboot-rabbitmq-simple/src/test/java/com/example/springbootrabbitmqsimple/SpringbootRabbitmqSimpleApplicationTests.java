package com.example.springbootrabbitmqsimple;

import com.example.springbootrabbitmqsimple.helloRabbitmq.HelloSender;
import com.example.springbootrabbitmqsimple.takeQueue.FanoutSender;
import com.example.springbootrabbitmqsimple.topicQueue.TopicSender;
import com.example.springbootrabbitmqsimple.workQueue.NeoSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqSimpleApplicationTests {

    @Autowired
    private HelloSender helloSender;

    @Autowired
    private NeoSender neoSender;

    @Autowired
    private FanoutSender fanoutSender;

    @Autowired
    private TopicSender topicSender;

    @Test
    public void send() {
        helloSender.send();
    }

    @Test
    public void oneToMany() {
        for (int i = 0; i < 50; i++) {
            neoSender.send(i);
        }
    }

    @Test
    public void setFanoutSender() {
        fanoutSender.send();
    }

    @Test
    public void topSender() {
        topicSender.send();
    }

    @Test
    public void topicSender1() {
        topicSender.send1();
    }

    @Test
    public void topicSender2() {
        topicSender.send2();
    }
}
