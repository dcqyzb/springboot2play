package com.example.springbootnettyserver.netty.cache;

import io.netty.channel.Channel;

import java.util.HashMap;

/**
 * 通道缓存管理
 * @author Mr.Deng
 * @date 15:46 2019/6/12
 */
public class ChannelRepository {

    private HashMap<String, Channel> channelCache = new HashMap<>();

    //添加通道缓存
    public ChannelRepository put(String key, Channel value) {
        channelCache.put(key, value);
        return this;
    }

    //获取缓存通道
    public Channel get(String key) {
        return channelCache.get(key);
    }

    //删除缓存通道
    public void remove(String key) {
        this.channelCache.remove(key);
    }

    //获取缓存通道数量
    public int size() {
        return this.channelCache.size();
    }
}
