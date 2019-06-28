/*
 * module: fundermental
 * file: Client4SerializableHandler.java
 * date: 6/28/19 11:03 AM
 * author: VectorJu
 */

/**
 * @create 2019-06-28 11:02
 * @desc serializble handler
 **/
package com.xlab.service_java_infrastructure.architecture.netty.serilize;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class Client4SerializableHandler extends ChannelHandlerAdapter {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        System.out.println("client exceptionCaught method run....");
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("from server : ClassName :" + msg.getClass().getName() + " ; message " + msg.toString());
    }
}

