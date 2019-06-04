package com.example.springbooteurekaclientdemo.service.impl;

import com.example.springbooteurekaclientdemo.service.ITestService;
import org.springframework.stereotype.Service;

/**
 * @创建人
 * @创建时间 2019/4/29
 * @描述
 */
@Service
public class TestServiceImpl implements ITestService {

    @Override
    public String getTest(String name) {
        return "Hello" + name;
    }
}
