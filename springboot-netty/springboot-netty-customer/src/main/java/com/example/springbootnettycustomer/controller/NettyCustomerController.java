package com.example.springbootnettycustomer.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootnettycustomer.start.ClientServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/4 17:29
 */
@RestController
public class NettyCustomerController {

    @Autowired
    private ClientServer clientServer;

    @GetMapping("/clientSend/{message}")
    public void clientSend(@PathVariable String message) {
        JSONObject ss = new JSONObject();
        ss.put("did", 123456);
//        clientServer.sendMessage(message);
    }

}
