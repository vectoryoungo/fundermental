/*
 * module: fundermental
 * file: Server4ProtocolHandler.java
 * date: 6/27/19 3:14 PM
 * author: VectorJu
 */

/**
 * @create 2019-06-27 15:14
 * @desc handler 4 server protocol
 **/
package com.xlab.service_java_infrastructure.architecture.netty.serilize;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class Server4ProtocolHandler extends ChannelHandlerAdapter{

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("server exceptionCaught method run...");
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        String mesage = msg.toString();
        System.out.println("server receive protocol content : " + mesage);
        mesage = ProtocolParser.parse(mesage);
        if (null == mesage) {
            System.out.println(" message is null not allow ");
            return;
        }
        System.out.println("from client : " + mesage);
        String line = "server message ";
        line = ProtocolParser.transferTo(line);
        System.out.println("server send protocol content : " + line);
        ctx.writeAndFlush(Unpooled.copiedBuffer(line.getBytes("UTF-8")));
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

