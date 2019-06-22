/*
 * module: fundermental
 * file: NIOServer.java
 * date: 6/22/19 10:27 AM
 * author: VectorJu
 */

/**
 * @create 2019-06-22 10:27
 * @desc nio programming
 **/
package com.xlab.service_java_infrastructure.architecture.nio;


import	java.nio.channels.SocketChannel;
import	java.net.InetSocketAddress;
import  java.nio.channels.CancelledKeyException;
import  java.nio.channels.SelectionKey;
import	java.nio.channels.ServerSocketChannel;
import  java.io.IOException;
import  java.nio.ByteBuffer;
import  java.nio.channels.Selector;
import  java.util.Iterator;
import  java.util.Scanner;

public class NIOServer implements Runnable {

    private Selector selector;
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

    public static void main(String[] args) {
        new Thread(new NIOServer(9999)).start();
    }

    public NIOServer (int port) {
        init(port);
    }
    @Override
    public void run() {

        while (true) {
            try {
                this.selector.select();
                Iterator<SelectionKey> keys = this.selector.selectedKeys().iterator();
                while (keys.hasNext()) {
                    SelectionKey key = keys.next();
                    //将本次要处理的通道从集合中删除，下次循环将根据新的通道列表再次执行必要的业务逻辑
                    keys.remove();
                    if (key.isValid()) {
                        //阻塞状态
                        try {

                            if (key.isAcceptable()) {
                                accept(key);
                            }

                        }catch (CancelledKeyException e) {
                            e.printStackTrace();
                            key.cancel();
                        }

                        try {
                            if (key.isReadable()) {
                                read(key);
                            }
                        }catch (CancelledKeyException e) {
                            e.printStackTrace();
                            key.cancel();
                        }

                        try {
                            if (key.isWritable()) {
                                write(key);
                            }
                        }catch (CancelledKeyException e){
                            e.printStackTrace();
                            key.cancel();
                        }
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void init(int port) {

        try {
            System.out.println("server starting at port " + port + "...");
            this.selector = Selector.open();
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.configureBlocking(false);
            serverChannel.bind(new InetSocketAddress(port));
            serverChannel.register(this.selector, SelectionKey.OP_ACCEPT);
            System.out.println("server started.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void accept(SelectionKey key) {
        try {
            ServerSocketChannel serverChannel = (ServerSocketChannel)key.channel();
            SocketChannel channel = serverChannel.accept();
            channel.configureBlocking(false);
            channel.register(this.selector,SelectionKey.OP_READ);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void read(SelectionKey key) {
        this.readBuffer.clear();
        SocketChannel channel = (SocketChannel) key.channel();
        try {
            int readLength = channel.read(readBuffer);
            if (readLength == -1) {
                key.channel().close();
                key.cancel();
                return;
            }

            this.readBuffer.flip();
            byte[] datas = new byte[readBuffer.remaining()];
            readBuffer.get(datas);
            System.out.println("from " + channel.getRemoteAddress() + " client: " + new String(datas,"UTF-8"));
            channel.register(this.selector,SelectionKey.OP_WRITE);
        }catch (IOException e) {
            e.printStackTrace();
            try {
                key.channel().close();
                key.cancel();
            }catch (IOException e1){
                e1.printStackTrace();
            }
        }
    }

    private void write(SelectionKey key) {
        this.writeBuffer.clear();
        SocketChannel channel = (SocketChannel) key.channel();
        Scanner reader= new Scanner(System.in);
        try {
            System.out.println("put message for send to client >");
            String line = reader.nextLine();
            writeBuffer.put(line.getBytes("UTF-8"));
            writeBuffer.flip();
            channel.write(writeBuffer);
            channel.register(this.selector,SelectionKey.OP_READ);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

