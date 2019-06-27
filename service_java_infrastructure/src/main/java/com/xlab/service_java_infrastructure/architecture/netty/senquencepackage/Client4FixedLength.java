/*
 * module: fundermental
 * file: Client4FixedLength.java
 * date: 6/25/19 5:30 PM
 * author: VectorJu
 */

/**
 * @create 2019-06-25 17:30
 * @desc client for fixed length
 **/
package com.xlab.service_java_infrastructure.architecture.netty.senquencepackage;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Client4FixedLength {

    private EventLoopGroup group = null;
    private Bootstrap bootstrap = null;

    public Client4FixedLength() {
        init();
    }

    private void init() {
            group = new NioEventLoopGroup();
            bootstrap = new Bootstrap();

            bootstrap.group(group);
            bootstrap.channel(NioSocketChannel.class);
    }

    public ChannelFuture doRequest(String host,int port) {

        this.bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ByteBuf delimiter = Unpooled.copiedBuffer("$E$".getBytes());
                ChannelHandler[] handlers = new ChannelHandler[3];
                //handlers [0] = new FixedLengthFrameDecoder(3);
                handlers [0] = new DelimiterBasedFrameDecoder(1024,delimiter);
                handlers [1] = new StringDecoder(Charset.forName("UTF-8"));
                handlers [2] = new Client4FixedLengthHandler();
                ch.pipeline().addLast(handlers);
            }
        });

        try {
            ChannelFuture future = this.bootstrap.connect(host, port).sync();
            return future;
        } catch (InterruptedException e) {
            e.printStackTrace();
            release();
            return null;
        }
    }

    public void release() {
        this.group.shutdownGracefully();
    }

    public static void main(String[] args) {

        Client4FixedLength client4FixedLength = null;
        ChannelFuture channelFuture = null;

        try{
            client4FixedLength = new Client4FixedLength();
            channelFuture = client4FixedLength.doRequest("localhost",9999);

            Scanner scanner = null;
            while (true) {
                scanner = new Scanner(System.in);
                System.out.print("enter message send to server > ");
                String line = scanner.nextLine();
                channelFuture.channel().writeAndFlush(Unpooled.copiedBuffer(line.getBytes("UTF-8")));
                TimeUnit.SECONDS.sleep(1);
            }
        }catch (InterruptedException e ) {
            e.printStackTrace();
        }catch(UnsupportedEncodingException e) {
           e.printStackTrace();
        }finally {

            if (null != channelFuture) {
                try {
                    channelFuture.channel().closeFuture().sync();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

            if (null !=client4FixedLength) {
                client4FixedLength.release();
            }

        }
    }
}


