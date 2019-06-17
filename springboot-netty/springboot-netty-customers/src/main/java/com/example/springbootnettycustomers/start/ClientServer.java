package com.example.springbootnettycustomers.start;

import com.example.springbootnettycustomers.handel.ClientChannelInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

    public void sendMessage(String message) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(new NioEventLoopGroup());
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.handler(new ClientChannelInitializer());
        ChannelFuture future = bootstrap.connect(host, port).sync();
        if (future.isSuccess()) {
            log.info("启动 Netty 成功");
        }
        SocketChannel channel = (SocketChannel) future.channel();
        channel.writeAndFlush("Hello Server Netty" + message + "\r\n");
        System.out.println("客户端发送数据");
    }

//    private static Object startAndWrite(InetSocketAddress address, Object send) throws InterruptedException {
//        init();
//        channelFuture = bootstrap.connect(address).sync();
//        // 传数据给服务端
//        channelFuture.channel().writeAndFlush(send);
//        channelFuture.channel().closeFuture().sync();
//        return channelFuture.channel().attr(AttributeKey.valueOf("Attribute_key")).get();
//    }
//
//    public void sendMessage(String message) {
//        try {
//            InetSocketAddress address = new InetSocketAddress(host, port);
//            Object result = ClientServer.startAndWrite(address, message);
//            log.info("....result:" + result);
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        } finally {
//            channelFuture.channel().close();
//            workerGroup.shutdownGracefully();
//            log.info("Closed client!");
//        }
//    }

}
