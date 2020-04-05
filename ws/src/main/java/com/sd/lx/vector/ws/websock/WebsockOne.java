/*
 * module: fundermental
 * file: WebsockOne.java
 * date: 4/5/20 5:29 PM
 * author: VectorJu
 */

/**
 * @create 2020-04-05 17:29
 * @desc one connect
 **/
package com.sd.lx.vector.ws.websock;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/websocketOne")
@Component
public class WebsockOne {

    // concurrent包的线程安全Set，用来存放每个客户端对应的WebSocketService对象。
    private static CopyOnWriteArraySet<WebsockOne> webSocketSet = new CopyOnWriteArraySet<WebsockOne>();
    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;


    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);

        try {
            sendMessage("连接成功");
        } catch (IOException e) {
            System.out.println("IO异常");
        }
    }

    /**
     * 收到客户端消息后调用的方法
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        for (WebsockOne item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发生错误时调用
     * */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
    }

    public void sendMessage(String message) throws IOException {
        // websocket  session发送文本消息有两个方法：
        // getAsyncRemote()和getBasicRemote() 推荐使用getAsyncRemote()这个方法
        // getBasicRemote是阻塞式的，getAsyncRemote是非阻塞式的
        // 。。。别问我，你在这里为什么使用getBasicRemote
        this.session.getBasicRemote().sendText(message);
    }
}

