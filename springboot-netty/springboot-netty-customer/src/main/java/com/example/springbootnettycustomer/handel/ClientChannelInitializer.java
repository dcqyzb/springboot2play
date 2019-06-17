package com.example.springbootnettycustomer.handel;

import com.example.springbootnettycustomer.encode.HeartbeatEncode;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/4 17:10
 */
public class ClientChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        //10 秒没发送消息 将IdleStateHandler 添加到 ChannelPipeline 中
        pipeline.addLast(new IdleStateHandler(0, 10, 0));
        pipeline.addLast(new EchoClientHandle());
        pipeline.addLast(new HeartbeatEncode());
        pipeline.addLast(new ClientHandler());
    }
}
