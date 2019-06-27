/*
 * module: fundermental
 * file: Server4Protocol.java
 * date: 6/27/19 2:50 PM
 * author: VectorJu
 */

/**
 * @create 2019-06-27 14:50
 * @desc
 **/
package com.xlab.service_java_infrastructure.architecture.netty.serilize;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

import java.nio.charset.Charset;

public class Server4Protocol {

    private EventLoopGroup acceptorGroup = null;
    private EventLoopGroup clientGroup = null;
    private ServerBootstrap bootstrap = null;
    public Server4Protocol() {
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

    public ChannelFuture doAccept(int port, final ChannelHandler... acceptorHandlers){
        bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new StringDecoder(Charset.forName("UTF-8")));
                ch.pipeline().addLast(acceptorHandlers);
            }
        });

        try {
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
        Server4Protocol server = null;

        try {
            server = new Server4Protocol();
            channelFuture = server.doAccept(9999,new Server4ProtocolHandler());
            System.out.print("server started ");
            channelFuture.channel().closeFuture().sync();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (null != channelFuture) {
                try {
                    channelFuture.channel().closeFuture().sync();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (null != server) {
                server.release();
            }
        }
    }
}

