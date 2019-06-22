/*
 * module: fundermental
 * file: NIOClient.java
 * date: 6/22/19 3:33 PM
 * author: VectorJu
 */

/**
 * @create 2019-06-22 15:33
 * @desc NIO client programming
 **/
package com.xlab.service_java_infrastructure.architecture.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class NIOClient {

    public static void main(String[] args) {
        InetSocketAddress remote = new InetSocketAddress("localhost",9999);
        SocketChannel channel = null;
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            channel = SocketChannel.open();
            channel.connect(remote);
            Scanner reader = new Scanner(System.in);
            while (true) {
                System.out.println("put message for send to server > ");
                String line = reader.nextLine();
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }

                buffer.put(line.getBytes("UTF-8"));
                buffer.flip();
                channel.write(buffer);
                buffer.clear();
                int readLength = channel.read(buffer);
                if (readLength == -1) {
                    break;
                }
                buffer.flip();
                byte[] datas = new byte[buffer.remaining()];
                buffer.get(datas);
                System.out.println("from server : " + new String(datas,"UTF-8"));
                buffer.clear();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (channel != null) {
                try {
                    channel.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

