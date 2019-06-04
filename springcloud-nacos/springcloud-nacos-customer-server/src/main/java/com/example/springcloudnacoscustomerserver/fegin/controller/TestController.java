package com.example.springcloudnacoscustomerserver.fegin.controller;

import com.example.springcloudnacoscustomerserver.fegin.Service.ITest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/5/30 18:14
 */
@RestController
public class TestController {

    @Autowired
    private ITest iTest;

    @GetMapping("/eCho/{ss}")
    public String eCho(@PathVariable String ss) {
        return iTest.echo(ss);
    }

    @GetMapping("/get")
    public Boolean configGet() {
        return iTest.get();
    }
}
