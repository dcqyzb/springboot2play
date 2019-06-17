package com.example.springbootnettyserver.netty.cache;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 通道缓存管理
 *
 * @author Mr.Deng
 * @date 15:46 2019/6/12
 */
public class ChannelRepository {

    private static HashMap<ChannelId, ChannelHandlerContext> channelHashMap = new HashMap<>();

    //添加通道缓存
    public static void put(ChannelId key, ChannelHandlerContext value) {
        channelHashMap.put(key, value);
    }

    //获取缓存通道
    public static ChannelHandlerContext get(ChannelId key) {
        return channelHashMap.get(key);
    }

    //删除缓存通道
    public static void remove(ChannelId key) {
        channelHashMap.remove(key);
    }

    public static Map<ChannelId, ChannelHandlerContext> getMap() {
        return channelHashMap;
    }

    //获取缓存通道数量
    public static int size() {
        return channelHashMap.size();
    }
}
