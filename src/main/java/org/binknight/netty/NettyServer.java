package org.binknight.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        //1.创建线程组bossGroup 和 workerGroup，前者只处理连接请求，后者处理客户端业务
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(8);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup(8);

        //2.创建服务端启动对象
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        // 使用链式编程配置server端参数
        //设置线程组
        serverBootstrap.group(bossGroup,workerGroup)
                //设置服务端通道实现
                .channel(NioServerSocketChannel.class)
                //初始化服务器连接队列大小，服务端处理客户端连接请求是顺序处理的，同一时间只能处理一个客户端连接
                //多个客户端请求来的时候，服务端将不能处理的客户端请求放在等待队列中等待处理
                .option(ChannelOption.SO_BACKLOG,1024)
                .childHandler(new ChannelInitializer<SocketChannel>() {//创建通道初始化对象，设置初始化参数

                    @Override
                    protected void initChannel(SocketChannel channel) throws Exception {
                        //对workerGroup中的SocketChannel设置处理器
                        channel.pipeline().addLast(new NettyServerHandler());
                    }
                })
                //3.启动服务器，bind是异步操作，sync是等异步操作结束
                .bind(9000).sync();
        System.out.println("netty server start...");
    }
}
