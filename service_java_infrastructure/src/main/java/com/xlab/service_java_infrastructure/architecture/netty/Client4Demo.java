/*
 * module: fundermental
 * file: Client4Demo.java
 * date: 6/25/19 2:14 PM
 * author: VectorJu
 */

/**
 * @create 2019-06-25 14:14
 * @desc client demo for netty
 **/
package com.xlab.service_java_infrastructure.architecture.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Client4Demo {

    private EventLoopGroup group = null;
    private Bootstrap bootstrap = null;

    public Client4Demo() {
        init();
    }

    private void init() {
        group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(group);
        bootstrap.channel(NioSocketChannel.class);
    }

    public ChannelFuture doRequest(String host, int port, final ChannelHandler...handlers) {
        this.bootstrap.handler(new ChannelInitializer<SocketChannel>() {

            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(handlers);
            }
        });
        ChannelFuture channelFuture = null;
        try {
            channelFuture = this.bootstrap.connect(host,port).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return channelFuture;
    }

    public void release() {
        this.group.shutdownGracefully();
    }

    public static void main(String[] args) {
        Client4Demo client4Demo = null;
        ChannelFuture channelFuture = null;

        client4Demo = new Client4Demo();
        channelFuture = client4Demo.doRequest("localhost",9999,new Client4DemoHanlder());
        Scanner scanner = null;

        try {
            while (true) {
                scanner = new Scanner(System.in);
                System.out.print("enter message send to server (enter 'exit' to close client)");
                String line = scanner.nextLine();
                if ("exit".equalsIgnoreCase(line)) {
                    channelFuture.channel().writeAndFlush(Unpooled.copiedBuffer(line.getBytes("UTF-8")))
                            .addListener(ChannelFutureListener.CLOSE);
                    break;
                }
                channelFuture.channel().writeAndFlush(Unpooled.copiedBuffer(line.getBytes("UTF-8")));
                TimeUnit.SECONDS.sleep(1);
            }
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (InterruptedException e ){
            e.printStackTrace();
        }finally {
            if (null != channelFuture) {
                try {
                    channelFuture.channel().closeFuture().sync();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (null != client4Demo) {
                client4Demo.release();
            }
        }

    }
}

