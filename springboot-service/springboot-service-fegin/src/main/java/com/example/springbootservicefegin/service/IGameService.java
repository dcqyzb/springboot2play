package com.example.springbootservicefegin.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @创建人
 * @创建时间 2019/4/29
 * @描述
 */
@FeignClient(name = "springboot-eureka-client-demo")
public interface IGameService {

    @RequestMapping("/getTest")
    String getGameTest();

}
