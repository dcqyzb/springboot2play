package com.example.springbootnettycustomer.start;

import com.example.springbootnettycustomer.handel.ClientChannelInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.net.InetSocketAddress;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/4 17:13
 */
@Service
public class ClientServer {

    private static final Logger log = Logger.getLogger(ClientServer.class);
    @Value("${netty.host}")
    private String host;
    @Value("${netty.port}")
    private Integer port;

    private static Bootstrap b;
    private static ChannelFuture f;
    private static final EventLoopGroup workerGroup = new NioEventLoopGroup();

    private static void init() {
        try {
            log.info("init...");
            b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ClientChannelInitializer());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object startAndWrite(InetSocketAddress address, Object send) throws InterruptedException {
        init();
        f = b.connect(address).sync();
        // 传数据给服务端
        f.channel().writeAndFlush(send);
        f.channel().closeFuture().sync();
        return f.channel().attr(AttributeKey.valueOf("Attribute_key")).get();
    }

    public void sendMessage(String message) {
        try {
            InetSocketAddress address = new InetSocketAddress(host, port);
            Object result = ClientServer.startAndWrite(address, message);
            log.info("....result:" + result);
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            f.channel().close();
            workerGroup.shutdownGracefully();
            log.info("Closed client!");
        }
    }

}
