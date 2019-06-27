/*
 * module: fundermental
 * file: Client4ProtocolHandler.java
 * date: 6/27/19 3:49 PM
 * author: VectorJu
 */

/**
 * @create 2019-06-27 15:49
 * @desc handler
 **/
package com.xlab.service_java_infrastructure.architecture.netty.serilize;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

public class Client4ProtocolHandler extends ChannelHandlerAdapter{

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("client exceptionCaught method run...");
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        try {
            String message = msg.toString();
            System.out.println("client receive protocol content: " + message);
            message = ProtocolParser.parse(message);
            if (null == message){
                System.out.println(" message is not allow null");
                return;
            }

            System.out.println("from server : " + message);
        }finally {
            ReferenceCountUtil.release(msg);
        }
    }

    static class ProtocolParser{
        public static String parse(String message) {
            String[] transfer = message.split("FUCK");
            transfer [0] = transfer[0].substring(4);
            transfer [1] = transfer[1].substring(0,(transfer[1].length() -4));
            int length = Integer.parseInt(transfer [0].substring(transfer[0].indexOf(":")+1));
            if (length != transfer[1].length()) {
                return null;
            }

            return transfer[1];

        }

        public static String transferTo(String message) {
            message = "HEADcontent-length:"+message.length()+"FUCK"+message+"BODY";
            return message;
        }
    }
}

