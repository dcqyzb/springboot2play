package com.example.springbootnettycustomer.handel;

import com.example.common.Protocol.CustomProtocol;
import com.example.springbootnettycustomer.config.HeartBeatConfig;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/13 9:35
 */
public class EchoClientHandle extends SimpleChannelInboundHandler<ByteBuf> {
    private final static Logger LOGGER = LoggerFactory.getLogger(EchoClientHandle.class);

    @Autowired
    private HeartBeatConfig heartBeatConfig;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {

        //从服务端收到消息时被调用
        LOGGER.info("客户端收到消息={}", byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端收到消息={" + byteBuf.toString(CharsetUtil.UTF_8) + "}");
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;

            if (idleStateEvent.state() == IdleState.WRITER_IDLE) {
                LOGGER.info("已经10秒没有发送消息了");
                System.out.println("已经10秒没有发送消息了");
                CustomProtocol heartBeat = heartBeatConfig.heartBeat();
                ctx.writeAndFlush(heartBeat).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
            }
        }
        super.userEventTriggered(ctx, evt);
    }
}
