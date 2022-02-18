package com.example.eofu.netty.chatroot.web.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.Future;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class WebSocketServer implements Runnable {
    @Autowired
    private ServerBootstrap serverBootstrap;
    @Autowired
    private EventLoopGroup bossGroup;
    @Autowired
    private EventLoopGroup workerGroup;
    private int port;
    private ChannelHandler childChannelHandler;
    private ChannelFuture serverChannelFuture;
    
    public WebSocketServer() {
    }
    
    public int getPort() {
        return port;
    }
    
    public void setPort(int port) {
        this.port = port;
    }
    
    public ChannelHandler getChildChannelHandler() {
        return childChannelHandler;
    }
    
    public void setChildChannelHandler(ChannelHandler childChannelHandler) {
        this.childChannelHandler = childChannelHandler;
    }
    
    @Override
    public void run() {
        build();
    }
    
    public void build() {
        try {
            long begin = System.currentTimeMillis();
            serverBootstrap.group(bossGroup, workerGroup)
                           .channel(NioServerSocketChannel.class)
                           .option(ChannelOption.SO_BACKLOG, 1024)
                           .option(ChannelOption.TCP_NODELAY, true)
                           .childOption(ChannelOption.SO_KEEPALIVE, true)
                           .childOption(ChannelOption.RCVBUF_ALLOCATOR, new FixedRecvByteBufAllocator(592048))
                           .childHandler(childChannelHandler);
            long end = System.currentTimeMillis();
            log.info("Netty Websocket服务器启动完成，耗时 " + (end - begin) + " ms，已绑定端口 " + port + " 阻塞式等候客户端连接");
            serverChannelFuture = serverBootstrap.bind(port)
                                                 .sync();
        } catch (InterruptedException e) {
            log.info(e.getMessage());
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
            e.printStackTrace();
        }
    }
    
    public void close() {
        serverChannelFuture.channel()
                           .close();
        Future<?> bossGroupFuture = bossGroup.shutdownGracefully();
        Future<?> workerGroupFuture = workerGroup.shutdownGracefully();
        
        try {
            bossGroupFuture.wait();
            workerGroupFuture.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
