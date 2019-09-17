package com.example.springbootnettyserver.netty.encode;

import com.example.Protocol.CustomProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class HeartbeatEncode extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext chx, ByteBuf in, List<Object> out) throws Exception {
        byte id = in.readByte();
        byte[] bytes = new byte[in.readableBytes()];
        in.readBytes(bytes);
        String content = new String(bytes);
        CustomProtocol customProtocol = new CustomProtocol();
        customProtocol.setId(Byte.toString(id));
        customProtocol.setContent(content);
        out.add(customProtocol);
    }
}
