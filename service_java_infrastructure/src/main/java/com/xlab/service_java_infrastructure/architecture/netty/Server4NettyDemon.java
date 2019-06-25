/*
 * module: fundermental
 * file: Server4NettyDemon.java
 * date: 6/25/19 10:08 AM
 * author: VectorJu
 */

/**
 * @create 2019-06-25 10:08
 * @desc demo netty server
 **/
package com.xlab.service_java_infrastructure.architecture.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server4NettyDemon {

    private EventLoopGroup acceptorGroup = null;
    private EventLoopGroup clientGroup = null;

    private ServerBootstrap bootstrap = null;

    public Server4NettyDemon() {
        init();
    }

    private void init() {

        acceptorGroup = new NioEventLoopGroup();
        clientGroup = new NioEventLoopGroup();
        bootstrap = new ServerBootstrap();
        bootstrap.group(acceptorGroup,clientGroup);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.option(ChannelOption.SO_BACKLOG,1024);
        bootstrap.option(ChannelOption.SO_SNDBUF,16*1024)
                 .option(ChannelOption.SO_RCVBUF,16*1024)
                 .option(ChannelOption.SO_KEEPALIVE,true);


    }

    public ChannelFuture doAccept(int port, final ChannelHandler...acceptorHandlers) {

        //server config bootstrap method , provide process object and like chain of responsibility
        bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel channel) throws Exception{
                channel.pipeline().addLast(acceptorHandlers);
            }
        });

        try {
            //bind listener port and could bind many port
            ChannelFuture future = bootstrap.bind(port).sync();
            return future;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void release() {
        this.acceptorGroup.shutdownGracefully();
        this.clientGroup.shutdownGracefully();
    }

    public static void main(String[] args) {
        ChannelFuture channelFuture = null;
        Server4NettyDemon server = null;
        try {

            server = new Server4NettyDemon();
            channelFuture = server.doAccept(9999,new Server4DemoHandler());
            System.out.println("server started ....");
            channelFuture.channel().closeFuture().sync();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (null != channelFuture) {
                try {
                    channelFuture.channel().closeFuture().sync();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (null != server) {
                server.release();
            }
        }
    }
}

