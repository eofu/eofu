package com.example.eofu.netty.apply.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println(new Date() + "������˶���������->" + byteBuf.toString(StandardCharsets.UTF_8));
        ByteBuf out = getByteBuf(ctx);
        ctx.channel().writeAndFlush(out);
    }

    /**
     * channelReadִ�к󴥷�
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.name() + "����Ϣ�Ѷ�ȡ���");
    }

    /**
     * ͨ������ʱ����
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String name = ctx.name();
        System.out.println(name + "�����ӣ�");
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        ByteBuf buffer = ctx.alloc().buffer();
        byte[] bytes = ("������ˡ����ѽ��յ���" + new Date()).getBytes(StandardCharsets.UTF_8);
        buffer.writeBytes(bytes);
        return buffer;
    }
}
