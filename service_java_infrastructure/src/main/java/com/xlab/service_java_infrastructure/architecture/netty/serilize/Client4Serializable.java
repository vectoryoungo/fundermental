/*
 * module: fundermental
 * file: Client4Serializable.java
 * date: 6/28/19 10:48 AM
 * author: VectorJu
 */

/**
 * @create 2019-06-28 10:48
 * @desc
 **/
package com.xlab.service_java_infrastructure.architecture.netty.serilize;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Client4Serializable {

    private EventLoopGroup group = null;
    private Bootstrap bootstrap = null;
    public Client4Serializable(){
        init();
    }

    private void init() {
        group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(group);
        bootstrap.channel(NioSocketChannel.class);
    }

    public ChannelFuture doRequest(String host, int port, final ChannelHandler... handlers) {
        this.bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(SerializableFactory4Marshalling.buildMarshallingDecorder());
                ch.pipeline().addLast(SerializableFactory4Marshalling.buildMarshallingEncode());
                ch.pipeline().addLast(handlers);
            }
        });

        ChannelFuture future = null;
        try {
            future = this.bootstrap.connect(host, port).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        return future;
    }

    public void release() {
        this.group.shutdownGracefully();
    }

    public static void main(String[] args) {
        Client4Serializable client = null;
        ChannelFuture future = null;

        client = new Client4Serializable();
        future = client.doRequest("localhost",9999,new Client4SerializableHandler());
        String attachment = " client test attachement ";
        byte[] attBuf = attachment.getBytes();
        attBuf = GzipUtils.zip(attBuf);
        RequestMessage requestMessage = new RequestMessage(new Random().nextLong(),"test",attBuf);
        future.channel().writeAndFlush(requestMessage);
        try {
            TimeUnit.SECONDS.sleep(1);
            future.addListener(ChannelFutureListener.CLOSE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (null != future) {
                try {
                    future.channel().closeFuture().sync();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (null != client) {
                client.release();
            }
        }
    }
}

