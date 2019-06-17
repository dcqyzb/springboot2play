package com.example.springbootnettyserver.netty.handel;

import com.example.Protocol.CustomProtocol;
import com.example.springbootnettyserver.netty.Common;
import com.example.springbootnettyserver.netty.cache.ChannelRepository;
import com.example.springbootnettyserver.netty.start.NettyStartServer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/12 16:02
 */
public class ImChatServerHandler extends SimpleChannelInboundHandler<CustomProtocol> {
    private final static Logger LOGGER = LoggerFactory.getLogger(ImChatServerHandler.class);

    private static final ByteBuf HEART_BEAT = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer(new CustomProtocol("123", "pong").toString(), CharsetUtil.UTF_8));


    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        LOGGER.info("绑定通道");
        ChannelRepository.put(ctx.channel().id(), ctx);
        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        NettySocketHolder.remove((NioSocketChannel) ctx.channel());
        ChannelRepository.remove(ctx.channel().id());
        System.err.println("掉线了...");
        //使用过程中断线重连
        LOGGER.info("解除通道");
        super.handlerRemoved(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            if (idleStateEvent.state() == IdleState.READER_IDLE) {
                LOGGER.info("已经5秒没有收到信息！");
                //向客户端发送消息
                ctx.writeAndFlush(HEART_BEAT).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
            }
        }
//        Map<Long, NioSocketChannel> map = NettySocketHolder.getMAP();
//        LOGGER.info("连接地址{}", map.toString());
        LOGGER.info("在线人数：" + ChannelRepository.size());
        super.userEventTriggered(ctx, evt);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CustomProtocol customProtocol) throws Exception {
        LOGGER.info("收到customProtocol={}", customProtocol.toString());
        //保存客户端与 Channel 之间的关系
        NettySocketHolder.put(customProtocol.getId(), (NioSocketChannel) ctx.channel());
    }
}
