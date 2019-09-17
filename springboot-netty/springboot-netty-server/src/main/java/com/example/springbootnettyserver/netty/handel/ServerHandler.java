package com.example.springbootnettyserver.netty.handel;

import com.example.springbootnettyserver.netty.Common;
import com.example.springbootnettyserver.netty.cache.ChannelRepository;
import com.example.springbootnettyserver.netty.start.NettyStartServer;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.EventLoop;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/4 16:10
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    private ChannelRepository channelRepository = new ChannelRepository();
    @Autowired
    private NettyStartServer nettyStartServer;

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel注册");
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel 不注册");
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive--->活跃状态");
        String socketAddress = ctx.channel().remoteAddress().toString();
        System.out.println(socketAddress);
        ctx.fireChannelActive();
        //远程地址
//        channelRepository.put(socketAddress, ctx.channel());
        ctx.writeAndFlush("Your channel key is" + socketAddress + "\n\r");
//        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelInactive ---》客户端与服务端断开连接之后");
        String s = ctx.channel().remoteAddress().toString();
        ctx.writeAndFlush("Your channel key is" + s + "remove \n\r");
        super.channelInactive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server channelRead......");
        System.out.println(ctx.channel().remoteAddress() + "----->Server :" + msg.toString());
        String message = (String) msg;
        System.out.println("send message :" + message);
        ctx.writeAndFlush(message + "\n\r");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel读取数据完毕");
        System.out.println("在线数：" + channelRepository.size());
        super.channelReadComplete(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println("用户事件触发");
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel可写事件更改");
        super.channelWritabilityChanged(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("捕获channel异常");
        super.exceptionCaught(ctx, cause);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("助手类添加");
        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("助手类移除");
        super.handlerRemoved(ctx);
    }

}
