package com.example.springbootnettycustomers.encode;

import com.example.Protocol.CustomProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class HeartbeatEncode extends MessageToByteEncoder<CustomProtocol> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, CustomProtocol customProtocol, ByteBuf byteBuf) throws Exception {
        byteBuf.writeBytes(customProtocol.getId().getBytes());
        byteBuf.writeBytes(customProtocol.getContent().getBytes());
    }
}
