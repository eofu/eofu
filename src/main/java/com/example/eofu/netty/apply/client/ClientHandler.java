package com.example.eofu.netty.apply.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class ClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * channelActive()�������ڿͻ�����������������Ӻ���á����������д�߼�����
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client send message:");
        // 1����ȡ����
        ByteBuf buffer = getByteBuf(ctx);
        // 2��д����
        ctx.channel().writeAndFlush(buffer);
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        // 1����ȡ�����Ƴ���ByteBuf
        // ���ַ����Ķ�����������䵽ByteBuf��
        ByteBuf buffer = ctx.alloc().buffer();
        // 2��׼�����ݣ�ָ���ַ������ַ���ΪUTF-8
        byte[] bytes = ("���ͻ��ˡ������ǿͻ��˷��͵���Ϣ��" + new Date()).getBytes(StandardCharsets.UTF_8);
        // 3��������ݵ�ByteBuf
        // ������д��������
        buffer.writeBytes(bytes);
        return buffer;
    }

    /**
     * �ڽ��ܵ�����˵���Ϣ�����
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        // ���շ������Ϣ
        System.out.println(byteBuf.toString(StandardCharsets.UTF_8));
    }
}
