/*
 * module: fundermental
 * file: Server4SerializableHandler.java
 * date: 6/28/19 10:15 AM
 * author: VectorJu
 */

/**
 * @create 2019-06-28 10:15
 * @desc serializable handler
 **/
package com.xlab.service_java_infrastructure.architecture.netty.serilize;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Random;

public class Server4SerializableHandler extends ChannelHandlerAdapter{
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("server exceptionCaught method run...");
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(" from client : ClassName :" + msg.getClass().getName() + "; message : " + msg.toString());
        if (msg instanceof RequestMessage) {
            RequestMessage requestMessage = (RequestMessage) msg;
            byte[] attachment = GzipUtils.unzip(requestMessage.getAttachment());
            System.out.println(new String(attachment));
        }

        ResponseMessage responseMessage = new ResponseMessage(new Random().nextLong(),"server test");
        ctx.writeAndFlush(responseMessage);
    }
}

