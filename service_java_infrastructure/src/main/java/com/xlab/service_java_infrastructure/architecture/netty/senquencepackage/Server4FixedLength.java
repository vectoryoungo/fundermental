/*
 * module: fundermental
 * file: Server4FixedLength.java
 * date: 6/25/19 4:22 PM
 * author: VectorJu
 */

/**
 * @create 2019-06-25 16:22
 * @desc fixed length for network package
 **/
package com.xlab.service_java_infrastructure.architecture.netty.senquencepackage;

import com.xlab.service_java_infrastructure.architecture.netty.Server4DemoHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

import java.nio.charset.Charset;

public class Server4FixedLength {

    private EventLoopGroup acceptorGroup = null;
    private EventLoopGroup clientGroup = null;
    private ServerBootstrap bootstrap = null;

    public Server4FixedLength() {
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
                 .option(ChannelOption.SO_RCVBUF,18*1024)
                 .option(ChannelOption.SO_KEEPALIVE,true);
    }

    public ChannelFuture doAccept(int port) {
        bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {

                ChannelHandler[] acceptorHandlers = new ChannelHandler[3];
                acceptorHandlers[0] = new FixedLengthFrameDecoder(3);
                acceptorHandlers[1] = new StringDecoder(Charset.forName("UTF-8"));
                acceptorHandlers[2] = new Server4FixedLengthHandler();
                ch.pipeline().addLast(acceptorHandlers);
            }
        });

        try {
            ChannelFuture channelFuture = bootstrap.bind(port).sync();
            return channelFuture;
        } catch (InterruptedException e) {
            e.printStackTrace();
            release();
            return null;
        }
    }

    public void release() {
        this.acceptorGroup.shutdownGracefully();
        this.clientGroup.shutdownGracefully();
    }

    public static void main(String[] args) {
        ChannelFuture future = null;
        Server4FixedLength server = null;

        try {
            server = new Server4FixedLength();
            future = server.doAccept(9999);
            System.out.println("server started ...");
            future.channel().closeFuture().sync();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (null != future) {
                try {
                    future.channel().closeFuture().sync();
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

