/*
 * module: fundermental
 * file: Client4FixedLengthHandler.java
 * date: 6/27/19 9:13 AM
 * author: VectorJu
 */

/**
 * @create 2019-06-27 09:13
 * @desc client 4 fixed lengh
 **/
package com.xlab.service_java_infrastructure.architecture.netty.senquencepackage;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

public class Client4FixedLengthHandler extends ChannelHandlerAdapter {


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        System.out.println("client exceptionCaught method run ...");
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            String message = msg.toString();
            System.out.println("from server : " + message);
        }finally {
            ReferenceCountUtil.release(msg);
        }
    }
}

