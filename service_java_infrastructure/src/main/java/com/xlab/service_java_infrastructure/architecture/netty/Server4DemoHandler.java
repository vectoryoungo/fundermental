/*
 * module: fundermental
 * file: Server4DemoHandler.java
 * date: 6/25/19 11:21 AM
 * author: VectorJu
 */

/**
 * @create 2019-06-25 11:21
 * @desc demo handler server
 **/
package com.xlab.service_java_infrastructure.architecture.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

@ChannelHandler.Sharable
public class Server4DemoHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception {
        ByteBuf readBuffer = (ByteBuf) msg;
        byte[] transfer = new byte [readBuffer.readableBytes()];
        readBuffer.readBytes(transfer);
        String message = new String(transfer,"UTF-8");
        System.out.println("from client : " + message);
        if ("exit".equalsIgnoreCase(message)) {
            ctx.close();
            return;
        }

        String line ="server message to client ";
        ctx.writeAndFlush(Unpooled.copiedBuffer(line.getBytes("UTF-8")));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("server exceptionCaught method run....");
        ctx.close();
    }
}

