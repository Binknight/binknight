package org.binknight.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 传统NIO将单线程的性能压榨到极致，但是请求多时while导致cpu飙升
 */
public class Nio {
    static List<SocketChannel> socketChannels = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9000));
        serverSocketChannel.configureBlocking(false);
        System.out.println("服务启动成功");

        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (null != socketChannel){
                System.out.println("连接成功");
                //设置socket channel 非阻塞
                socketChannel.configureBlocking(false);
                // 客户端连接放入channel list
                socketChannels.add(socketChannel);
            }

            Iterator<SocketChannel> iterator = socketChannels.iterator();

            while (iterator.hasNext()){
                SocketChannel socketChannel1 = iterator.next();
                ByteBuffer buffer = ByteBuffer.allocate(6);
                // 非阻塞read，不会blocking
                int length = socketChannel1.read(buffer);
                if (length>0){
                    System.out.println("收到消息： " + new String(buffer.array()));
                }else if (length == -1){
                    iterator.remove();
                    System.out.println("客户端断开连接");
                }

            }
        }



    }
}
