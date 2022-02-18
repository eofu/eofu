package com.example.eofu.io.aio.chatroom.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yangshuai
 */
public class ChatServer {
    /**
     * ���û������ֽڴ�С
     */
    private static final int BUFFER = 1024;
    /**
     * �����û��б�Ϊ�˲����µ��̰߳�ȫ������ʹ��CopyOnWriteArrayList
     * CopyOnWriteArrayList��дʱ��������ʱ��������������Ŀ������ת����Ϣʱ��ҪƵ����ȡ.
     * ClientHandler����ÿ���ͻ��˵�ͨ��������ѡ��ΪClientHandler��Ϊ����write��ʱ�����ÿ���ͻ��˵�handler
     */
    private final CopyOnWriteArrayList<ClientHandler> clientHandlerList;
    /**
     * �ַ����ַ�����ת��Ҫ�õ����涨���뷽ʽ��������������
     */
    private final Charset charset = StandardCharsets.UTF_8;
    /**
     * ͨ�����캯�����ü����˿�
     */
    private final int port;
    /**
     * ����AsynchronousServerSocketChannel��AsynchronousChannelGroup
     */
    private AsynchronousServerSocketChannel serverSocketChannel;
    private AsynchronousChannelGroup channelGroup;

    public ChatServer(int port) {
        this.port = port;
        clientHandlerList = new CopyOnWriteArrayList<>();
    }

    public static void main(String[] args) {
        new ChatServer(8888).start();
    }

    public void start() {
        try {
            // ����һ���̳߳ز����̳߳غ�AsynchronousChannelGroup�󶨣�ǰ���ᵽ��AsynchronousChannelGroup����һЩϵͳ��Դ�����߳̾�������һ�֡�
            // Ϊ�˷���������Ǿ����Ұ��������̳߳أ�ʵ���ϲ���ֹ�����̳߳ء��������Ҫ�Լ�ѡ���̳߳����ͺ��������Ϳ������²���
            // �������Ҫ�Զ����̳߳����ͺ����������Բ���д�������д��롣
            ExecutorService executorService = Executors.newFixedThreadPool(10);
            channelGroup = AsynchronousChannelGroup.withThreadPool(executorService);
            serverSocketChannel = AsynchronousServerSocketChannel.open(channelGroup);
            serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", port));
            System.out.println("�������������˿ڡ�" + port + "��");
            /*
              AIO��accept�����첽���ã���������˵����CompletionHandler��ʽ
              ��һ�������Ǹ����������ص������п��ܻ����ϵģ����û�о���null;�ڶ�������ΪCompletionHandler�ӿڵ�ʵ��
              ����ʹ��while��System.in.read()��ԭ��
              while��Ϊ���÷�������������״̬��ǰ���NIO��BIO�����õ�while����ѭ�������ַ��������У����������õĵط����ܸ������
              System.in.read()������ʽ�ĵ��ã�ֻ�ǵ����ı�������ѭ������acceptƵ�������ã���ʵ��ҵ���ܡ�
             */
            while (true) {
                serverSocketChannel.accept(null, new AcceptHandler());
                System.in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocketChannel != null) {
                try {
                    serverSocketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * ת����Ϣ�ķ���
     */
    private void sendMessage(AsynchronousSocketChannel clientChannel, String msg) {
        for (ClientHandler handler : clientHandlerList) {
            if (!handler.clientChannel.equals(clientChannel)) {
                ByteBuffer buffer = charset.encode(msg);
                //write����Ҫbuffer��������������Ϊд���ͻ��˵�ͨ���������ˣ���������Ҫ�ص�����ת���������ͻ��ˡ�
                handler.clientChannel.write(buffer, null, handler);
            }
        }
    }

    /**
     * ���ݿͻ���channel��ȡ��Ӧ�˿ںŵķ���
     */
    private String getPort(AsynchronousSocketChannel clientChannel) {
        try {
            InetSocketAddress address = (InetSocketAddress) clientChannel.getRemoteAddress();
            return "�ͻ���[" + address.getPort() + "]:";
        } catch (IOException e) {
            e.printStackTrace();
            return "�ͻ���[Undefined]:";
        }
    }

    /**
     * �Ƴ��ͻ���
     */
    private void removeClient(ClientHandler handler) {
        clientHandlerList.remove(handler);
        System.out.println(getPort(handler.clientChannel) + "�Ͽ�����...");
        if (handler.clientChannel != null) {
            try {
                handler.clientChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * AsynchronousSocketChannelΪaccept���ص����ͣ�ObjectΪ�����������ͣ�û�о���Object
     */
    private class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {
        //����ɹ���ִ�еĻص�����
        @Override
        public void completed(AsynchronousSocketChannel clientChannel, Object attachment) {
            //���������û�رգ��ڽ����굱ǰ�ͻ��˵�������ٴε���,�Խ��Ž��������ͻ��˵�����
            if (serverSocketChannel.isOpen()) {
                serverSocketChannel.accept(null, this);
            }
            //����ͻ��˵�channelû�йر�
            if (clientChannel != null && clientChannel.isOpen()) {
                //��������첽read��writeҪ�õ���handler,�����뵱ǰ�ͻ��˵�channel
                ClientHandler handler = new ClientHandler(clientChannel);
                //�����û���ӵ������û��б���
                clientHandlerList.add(handler);
                System.out.println(getPort(clientChannel) + "��������");
                ByteBuffer buffer = ByteBuffer.allocate(BUFFER);
                // �첽����read,��һ��buffer�Ǵ�Ŷ������ݵ��������ڶ����Ǹ���������
                // ��Ϊ�����Ĵ�������handler��Ļص��������еģ�����������ֱ�Ӵ����ص�����������Ϊ�˷���ʹ�ã�buffer�͵�����������
                clientChannel.read(buffer, buffer, handler);
            }
        }

        //���ʧ�ܣ�ִ�еĻص�����
        @Override
        public void failed(Throwable exc, Object attachment) {
            System.out.println("����ʧ��" + exc);
        }
    }

    private class ClientHandler implements CompletionHandler<Integer, ByteBuffer> {
        private final AsynchronousSocketChannel clientChannel;

        public ClientHandler(AsynchronousSocketChannel clientChannel) {
            this.clientChannel = clientChannel;
        }

        @Override
        public void completed(Integer result, ByteBuffer buffer) {
            if (buffer != null) {
                //���read���صĽ��С�ڵ���0����buffer��Ϊ�գ�˵���ͻ���ͨ�������쳣�������߲���
                if (result <= 0) {
                    removeClient(this);
                } else {
                    //ת��buffer��дģʽ����ȡ��Ϣ
                    buffer.flip();
                    String msg = String.valueOf(charset.decode(buffer));
                    //�ڷ������ϴ�ӡ�ͻ��˷�������Ϣ
                    System.out.println(getPort(clientChannel) + msg);
                    //����Ϣת���������ͻ���
                    sendMessage(clientChannel, getPort(clientChannel) + msg);
                    buffer = ByteBuffer.allocate(BUFFER);

                    //����û���������˳����ʹ������б����Ƴ���������ż�������û�������Ϣ
                    if ("quit".equals(msg)) {
                        removeClient(this);
                    } else {
                        clientChannel.read(buffer, buffer, this);
                    }
                }
            }
        }

        @Override
        public void failed(Throwable exc, ByteBuffer attachment) {
            System.out.println("�ͻ��˶�д�쳣��" + exc);
        }
    }
}
