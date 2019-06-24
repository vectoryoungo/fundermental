package com.xlab.service_java_infrastructure.architecture.aio;
import ch.qos.logback.core.util.TimeUtil;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;

import	java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AIOServer {

    private ExecutorService executor;

    private AsynchronousServerSocketChannel channel;

    public AIOServer(int port) {
        init(9999);
    }

    private void init(int port) {
        try {
            System.out.println("server starting at port : " + port + " ... ");
            executor = Executors.newFixedThreadPool(4);
            channel = AsynchronousServerSocketChannel.open();
            channel.bind(new InetSocketAddress(port));
            System.out.println("server started ");
            channel.accept(this,new AIOServerHandler());
            try {
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AIOServer(9999);
    }

    public ExecutorService getExecutor() {
        return executor;
    }

    public void setExecutor(ExecutorService executor) {
        this.executor = executor;
    }

    public AsynchronousServerSocketChannel getChannel() {
        return channel;
    }

    public void setChannel(AsynchronousServerSocketChannel channel) {
        this.channel = channel;
    }
}

