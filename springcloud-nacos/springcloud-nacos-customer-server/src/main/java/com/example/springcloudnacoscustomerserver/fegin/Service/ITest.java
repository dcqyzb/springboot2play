package com.example.springcloudnacoscustomerserver.fegin.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/5/30 18:08
 */
@FeignClient(name = "springcloud-nacos-discovery-server1")
public interface ITest {

    @GetMapping("/echo/{ss}")
    String echo(@PathVariable(value = "ss") String ss);

    @GetMapping("/config/get")
    boolean get();
}
