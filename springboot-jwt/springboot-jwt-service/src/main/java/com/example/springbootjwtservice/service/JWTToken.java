package com.example.springbootjwtservice.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @创建人
 * @创建时间 2019/4/29
 * @描述 获取token
 */
public class JWTToken {

    public Map<String, Object> getToken(@RequestParam String name) {
        Map<String, Object> resultMap = new HashMap<>();
        //生成jwt

        return resultMap;

    }

    private String buildJWT(String name) {
        //生成JWT
        LocalDateTime localDateTime = LocalDateTime.now();

        return "";
    }

}