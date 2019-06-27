
/*
 * module: fundermental
 * file: Client4Protocol.java
 * date: 6/27/19 3:32 PM
 * author: VectorJu
 */

/**
 * @create 2019-06-27 15:32
 * @desc protocol
 **/
package com.xlab.service_java_infrastructure.architecture.netty.serilize;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

import java.io.UnsupportedEncodingException;
import	java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Client4Protocol {

    private EventLoopGroup group = null;
    private Bootstrap bootstrap = null;

    public Client4Protocol() {
        init();
    }

    private void init() {
        group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(group);
        bootstrap.channel(NioSocketChannel.class);
    }

    public ChannelFuture doRequest(String host, int port, final ChannelHandler... channelHandlers) {
        this.bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new StringDecoder(Charset.forName("UTF-8")));
                ch.pipeline().addLast(channelHandlers);
            }
        });

        try {
            ChannelFuture future = this.bootstrap.connect(host, port).sync();
            return future;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void release() {
        this.group.shutdownGracefully();
    }

    public static void main(String[] args) {
        Client4Protocol client4Protocol = null;
        ChannelFuture channelFuture = null;

        client4Protocol = new Client4Protocol();
        channelFuture = client4Protocol.doRequest("localhost",9999,new Client4ProtocolHandler());
        Scanner scanner = null;

        try {
            while (true) {
                scanner = new Scanner(System.in);
                System.out.print("enter message send to server > ");
                String line = scanner.nextLine();
                line = Client4ProtocolHandler.ProtocolParser.transferTo(line);
                System.out.println("client send protocol content: " + line);
                channelFuture.channel().writeAndFlush(Unpooled.copiedBuffer(line.getBytes("UTF-8")));
                TimeUnit.SECONDS.sleep(1);
            }
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
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

            if (null != client4Protocol) {
                client4Protocol.release();
            }
        }

    }
}

