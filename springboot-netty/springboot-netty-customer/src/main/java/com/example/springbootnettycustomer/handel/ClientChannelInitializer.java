package com.example.springbootnettycustomer.handel;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/4 17:10
 */
public class ClientChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline().addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
        channel.pipeline().addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
        channel.pipeline().addLast(new ClientHandler());
    }
}
