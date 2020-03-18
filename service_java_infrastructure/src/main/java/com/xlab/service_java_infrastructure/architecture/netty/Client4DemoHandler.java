/**
 * @create 2019-06-25 14:32
 * @desc client handler
 **/
package com.xlab.service_java_infrastructure.architecture.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

public class Client4DemoHandler extends ChannelHandlerAdapter {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("client exception caught run ...");
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            ByteBuf bb = (ByteBuf) msg;
            byte[] transfer = new byte [bb.readableBytes()];
            bb.readBytes(transfer);
            System.out.println("from server : " + new String(transfer,"UTF-8"));
        }finally {
            //for release cache in case of prevent memory leak
            ReferenceCountUtil.release(msg);
        }
    }
}

