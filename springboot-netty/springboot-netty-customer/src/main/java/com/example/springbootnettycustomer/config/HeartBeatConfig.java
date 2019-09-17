package com.example.springbootnettycustomer.config;

import com.example.Protocol.CustomProtocol;
import com.example.springbootnettycustomer.Common;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/13 9:43
 */
@Configuration
public class HeartBeatConfig {
    @Bean(value = "heartBeat")
    public CustomProtocol heartBeat() {
        return new CustomProtocol(Common.Channel_id, "ping");
    }
}
