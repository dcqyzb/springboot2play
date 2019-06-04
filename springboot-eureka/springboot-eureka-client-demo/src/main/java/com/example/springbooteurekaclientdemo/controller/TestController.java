package com.example.springbooteurekaclientdemo.controller;

import com.example.springbooteurekaclientdemo.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @创建人
 * @创建时间 2019/4/29
 * @描述
 */
@RestController
public class TestController {

    @Autowired
    private ITestService iTestService;

    @RequestMapping("/getTest")
    public String getTest() {
        String world = iTestService.getTest("world");
        return world;
    }
}
