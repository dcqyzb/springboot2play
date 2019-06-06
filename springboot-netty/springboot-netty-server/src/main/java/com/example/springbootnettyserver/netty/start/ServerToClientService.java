package com.example.springbootnettyserver.netty.start;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springbootnettyserver.netty.exception.MessageSendFaidException;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Mr.Deng
 * @description
 * @date 2019/6/4 18:00
 */
@Component
public class ServerToClientService {

    private static final Logger sLogger = Logger.getLogger(ServerToClientService.class);

    private Channel channel;

    public static final AttributeKey<String> DEVICE_ID = AttributeKey.valueOf("DEVICE_ID");

    //发送消息
    public void sendMessage(String message) throws Exception {
        if (message == null) {
            return;
        }
        Attribute<String> deviceStr = channel.attr(DEVICE_ID);
        String deviceId = deviceStr == null ? null : deviceStr.get();
        sLogger.info("给客户端发消息  message-->" + message + ",channel-->" + JSONObject.toJSONString(channel));
        if (channel != null && channel.isWritable()) {
            ChannelFuture future = channel.writeAndFlush(message);
            sLogger.info("im send message success:" + message + "; deviceId: " + deviceId);
            if (future.isSuccess()) {
                sLogger.info("future im send message success:" + message + "; deviceId: " + deviceId);
            }
        } else {
            channel.close();
            sLogger.error("im send message error un writable :" + message);
            throw new MessageSendFaidException();
        }
    }

    //接收消息
    public void lsMessage(String message) {
        JSONObject jsonObject = JSON.parseObject(message);
        String deviceId = jsonObject.getString("did");
        channel.attr(DEVICE_ID).set(deviceId);
        channel.writeAndFlush(JSONObject.toJSONString(message));
    }
}
