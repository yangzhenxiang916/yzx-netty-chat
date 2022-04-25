package com.yzx.netty.chat.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

public class ChatServerChannelInitializer extends ChannelInitializer {
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();
        //处理http
        channelPipeline.addLast(new HttpServerCodec());//http编码器
        channelPipeline.addLast(new ChunkedWriteHandler());//大数据分批处理
        channelPipeline.addLast(new HttpObjectAggregator(6 * 1024));//聚合fullHttpRequest或fullHttpResponse

        channelPipeline.addLast(new HttpServerHandler());
        channelPipeline.addLast(new IdleStateHandler(4, 8, 12));
        // 自定义的空闲状态检测
        channelPipeline.addLast(new HeartBeatHandler());
        //处理webSocket请求
        channelPipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        channelPipeline.addLast(new WebSocketServerHandler());
    }
}
