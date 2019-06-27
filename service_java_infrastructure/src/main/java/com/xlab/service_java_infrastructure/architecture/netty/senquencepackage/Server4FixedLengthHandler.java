/*
 * module: fundermental
 * file: Server4FixedLengthHandler.java
 * date: 6/25/19 5:11 PM
 * author: VectorJu
 */

/**
 * @create 2019-06-25 17:11
 * @desc handle server fixed length
 **/
package com.xlab.service_java_infrastructure.architecture.netty.senquencepackage;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class Server4FixedLengthHandler extends ChannelHandlerAdapter{

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("server exceptionCaught method run ...");
        ctx.close();

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String message = msg.toString();
        System.out.println(" from client : " + message);
        String line = "ok ";
        ctx.writeAndFlush(Unpooled.copiedBuffer(line.getBytes("UTF-8")));
    }
}

