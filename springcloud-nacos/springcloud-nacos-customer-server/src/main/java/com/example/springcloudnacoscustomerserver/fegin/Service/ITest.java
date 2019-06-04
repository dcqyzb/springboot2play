package com.example.springcloudnacoscustomerserver.fegin.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/5/30 18:08
 */
@FeignClient(name = "springcloud-nacos-discovery-server")
public interface ITest {

    @GetMapping("/echo/{string}")
    String echo(@PathVariable String string);

    @GetMapping("/config/get")
    boolean get();
}
