package com.example.springbootnettyserver.netty.start;

import com.example.springbootnettyserver.netty.handel.ServerChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/4 15:53
 */
@Component
public class NettyStartServer {

    private static final Logger LOGGER = Logger.getLogger(NettyStartServer.class);

    public void start(InetSocketAddress address) {
        EventLoopGroup boosGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap()
                    .group(boosGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(address)
                    .childHandler(new ServerChannelInitializer())
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            //绑定端口，开始接收进来的连接
            ChannelFuture future = bootstrap.bind(address).sync();
            LOGGER.info("server start listen at " + address.getPort());
            System.out.println("server start listen at " + address.getPort());
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
            boosGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}
