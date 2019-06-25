package com.example.provider.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.api.entity.User;
import com.example.api.service.UserService;
import jdk.nashorn.internal.ir.annotations.Reference;

@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {
    @Override
    public User getUser() {
        User user = new User();
        user.setId(1L);
        user.setUserName("HEllo");
        user.setPassword("WoRd");
        return user;
    }
}
