package com.example.springbootnettyserver.netty.handel;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.HashMap;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/12 16:02
 */
public class ImChatServerHandler extends SimpleChannelInboundHandler<String> {

    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

//    //用于存储设备和channel的绑定关系
//    private Map<String, Channel> deviceAndChannel= new HashMap<String, Channel>();
//    //用于存储Channel和Device的绑定关系，方便channel断开连接时，能快速地找到对应的设备和用户，并解除绑定关系
//    private Map<Channel, String> channelAndDevice= new HashMap<Channel, String>();

    /**
     * 绑定chanel 与 用户 id
     */
    private BiMap<String, Channel> driverAndDevice = HashBiMap.create(new HashMap<String, Channel>());
    private BiMap<String, Channel> passengerAndDevice = HashBiMap.create(new HashMap<String, Channel>());
//    private BiMap<String, Document> idAndName = HashBiMap.create(new HashMap<String, Document>());



    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("绑定通道");
        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("解除通道");
        super.handlerRemoved(ctx);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println("读取到的信息：" + s);
    }
}
