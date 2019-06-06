package com.example.springbootnettyserver.controller;

import com.example.springbootnettyserver.netty.start.ServerToClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/4 18:06
 */
@RestController
public class NettyServerController {

    @Autowired
    private ServerToClientService serverToClientService;

    @GetMapping("/serverSend/{message}")
    public void serverSend(@PathVariable String message) throws Exception {
        serverToClientService.sendMessage(message);
    }

}
