package com.example.springcloudnacosdiscoveryserver.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/5/30 17:35
 */
@RestController
public class EchoController {

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }
}
