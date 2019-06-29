/*
 * module: fundermental
 * file: Server4Serializable.java
 * date: 6/27/19 4:37 PM
 * author: VectorJu
 */

/**
 * @create 2019-06-27 16:37
 * @desc server 4 serilize
 **/
package com.xlab.service_java_infrastructure.architecture.netty.serilize;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server4Serializable {
    private EventLoopGroup acceptorGroup = null;
    private EventLoopGroup clientGroup = null;
    private ServerBootstrap bootstrap = null;

    public Server4Serializable() {
        init();
    }

    private void init() {
        acceptorGroup = new NioEventLoopGroup();
        clientGroup = new NioEventLoopGroup();
        bootstrap = new ServerBootstrap();
        bootstrap.group(acceptorGroup,clientGroup);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.option(ChannelOption.SO_BACKLOG,1024);
        bootstrap.option(ChannelOption.SO_SNDBUF,10*1024)
                 .option(ChannelOption.SO_RCVBUF,16*1024)
                 .option(ChannelOption.SO_KEEPALIVE,true);

    }

    public ChannelFuture doAccept(int port, final ChannelHandler... channelHandlers) {
        bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(SerializableFactory4Marshalling.buildMarshallingEncode());
                ch.pipeline().addLast(SerializableFactory4Marshalling.buildMarshallingDecorder());
                ch.pipeline().addLast(channelHandlers);
            }
        });

        try {
            ChannelFuture channelFuture = this.bootstrap.bind(port).sync();
            return channelFuture;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void release() {
        this.clientGroup.shutdownGracefully();
        this.acceptorGroup.shutdownGracefully();
    }

    public static void main(String[] args) {


        ChannelFuture channelFuture = null;
        Server4Serializable server = null;

        try {
            server = new Server4Serializable();
            channelFuture = server.doAccept(9999,new Server4SerializableHandler());
            System.out.println("server started ...");
            channelFuture.channel().closeFuture().sync();
        }catch (InterruptedException e){
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

