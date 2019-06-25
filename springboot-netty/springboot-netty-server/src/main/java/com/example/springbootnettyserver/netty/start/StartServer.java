package com.example.springbootnettyserver.netty.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/4 16:30
 */
@Configuration
public class StartServer implements CommandLineRunner {
    @Value("${netty.url}")
    private String url;
    @Value("${netty.port}")
    private Integer port;

    @Autowired
    private NettyStartServer server;

    @Override
    public void run(String... args) throws Exception {
        InetSocketAddress address = new InetSocketAddress(url, port);
        System.out.println("run........" + url);
        server.start(address);
    }
}
