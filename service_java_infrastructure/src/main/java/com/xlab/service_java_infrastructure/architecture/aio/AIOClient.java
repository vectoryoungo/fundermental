/*
 * module: fundermental
 * file: AIOClient.java
 * date: 6/24/19 3:57 PM
 * author: VectorJu
 */

/**
 * @create 2019-06-24 15:57
 * @desc aio client programming
 **/
package com.xlab.service_java_infrastructure.architecture.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class AIOClient {

    private AsynchronousSocketChannel channel;
    public AIOClient(String host,int port) {
        init(host,port);
    }

    private void init(String host,int port) {
        try {
            channel = AsynchronousSocketChannel.open();
            channel.connect(new InetSocketAddress(host,port));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String line) {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put(line.getBytes("UTF-8"));
            buffer.flip();
            channel.write(buffer);
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public void read(){
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        try {
            channel.read(buffer).get();
            buffer.flip();
            System.out.println("from server : " + new String(buffer.array(),"UTF-8"));
        }catch (InterruptedException e) {
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void doDestory() {
        if (null !=channel) {
            try {
                channel.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        AIOClient client = new AIOClient("localhost",9999);
        try {

            System.out.print("enter message send to server > ");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            client.write(line);
            client.read();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            client.doDestory();
        }
    }
}

