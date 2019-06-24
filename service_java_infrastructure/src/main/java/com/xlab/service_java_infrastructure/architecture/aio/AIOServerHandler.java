/*
 * module: fundermental
 * file: AIOServerHandler.java
 * date: 6/22/19 5:04 PM
 * author: VectorJu
 */

/**
 * @create 2019-06-22 17:04
 * @desc
 **/
package com.xlab.service_java_infrastructure.architecture.aio;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Scanner;

public class AIOServerHandler implements CompletionHandler<AsynchronousSocketChannel,AIOServer>{
    @Override
    public void completed(AsynchronousSocketChannel result, AIOServer attachment) {
        attachment.getChannel().accept(attachment,this);
        doRead(result);

    }

    @Override
    public void failed(Throwable exc, AIOServer attachment) {
        exc.printStackTrace();
    }

    private void doWrite(AsynchronousSocketChannel result) {

        try {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            System.out.println("enter message send to client > ");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            byteBuffer.put(line.getBytes("UTF-8"));
            byteBuffer.flip();
            result.write(byteBuffer);
        }catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

    }

    private void doRead(AsynchronousSocketChannel channel) {

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        channel.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                try {
                    System.out.println(attachment.capacity());
                    attachment.flip();
                    System.out.println("from client: " + new String(attachment.array(),"UTF-8"));
                    doWrite(channel);
                }catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                exc.printStackTrace();
            }
        });
    }
}

