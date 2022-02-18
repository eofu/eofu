package com.example.eofu.netty.chatroot.web.websocket;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class WebSocketChildChannelHandler extends ChannelInitializer<SocketChannel> {
    @Resource(name = "webSocketServerHandler")
    private ChannelHandler channelHandler;
    
    @Resource(name = "httpRequestHandler")
    private ChannelHandler httpRequestHandler;
    
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        // ch.pipeline().addLast("http-codec")
        
        
        ch.pipeline().addLast("http-handler", httpRequestHandler);
        ch.pipeline().addLast("websocket-handler", httpRequestHandler);
    }
}
