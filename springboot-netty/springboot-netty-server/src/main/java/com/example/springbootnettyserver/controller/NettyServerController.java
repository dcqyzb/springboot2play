package com.example.springbootnettyserver.controller;

import com.example.Protocol.CustomProtocol;
import com.example.springbootnettyserver.netty.cache.ChannelRepository;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/4 18:06
 */
@RestController
public class NettyServerController {

    @RequestMapping("/sendAll")
    public String sendAll(String message) {
        return message + "成功";
    }
}
