package com.example.springbootnettycustomers.controller;

import com.example.springbootnettycustomers.start.ClientServer;
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
    public void clientSend(@PathVariable String message) throws InterruptedException {
        clientServer.sendMessage(message);
//        clientServer.sendMessage(message);
    }

}
