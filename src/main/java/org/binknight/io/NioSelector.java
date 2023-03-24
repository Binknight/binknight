package org.binknight.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;


/**
 * NIO, Selector多路复用器
 */
public class NioSelector {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9000));
        serverSocketChannel.configureBlocking(false);
        // 开启多路复用器
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务启动成功1");

        while (true){
            //阻塞等待事件到来（会出让cpu不会消耗系统资源）
            selector.select();

            // 获取selector中注册的全部事件列表selection key实例
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            // 遍历selection key 对时间进行处理
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()){
                    ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = channel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_READ);
                    System.out.println("客户端连接成功");
                }else if (selectionKey.isReadable()){
                    SocketChannel socketChannel1 = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(6);
                    int length = socketChannel1.read(buffer);
                    // 非阻塞read，不会blocking
                    if (length>0){
                        System.out.println("收到消息： " + new String(buffer.array()));
                    }else if (length == -1){
                        System.out.println("客户端断开连接");
                        socketChannel1.close();
                    }
                }
                iterator.remove();
            }
        }
    }
}
