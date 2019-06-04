package com.example.springbootjwtservice.redis.config;

import com.example.springbootjwtservice.redis.RedisObjectSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @创建人
 * @创建时间 2019/4/30
 * @描述
 */
@Component
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> getRedisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());//key的序列化类型
        redisTemplate.setValueSerializer(new RedisObjectSerializer());//value 的序列化类型
        return redisTemplate;
    }
}
