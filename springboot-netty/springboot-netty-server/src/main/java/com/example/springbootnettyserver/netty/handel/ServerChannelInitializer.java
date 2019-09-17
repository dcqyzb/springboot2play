package com.example.springbootnettyserver.netty.handel;

import com.example.springbootnettyserver.netty.encode.HeartbeatEncode;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/4 16:06
 */
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServerChannelInitializer.class);

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        //五秒没有收到消息 将IdleStateHandler 添加到 ChannelPipeline 中
        pipeline.addLast(new IdleStateHandler(5, 0, 0));
        pipeline.addLast(new HeartbeatEncode());
        pipeline.addLast(new ImChatServerHandler());
        pipeline.addLast(new ServerHandler());
        LOGGER.info("SimpleChatClient:" + channel.remoteAddress() + "连接上");
    }
}
