/*
 * module: fundermental
 * file: WebsockMany.java
 * date: 4/5/20 5:32 PM
 * author: VectorJu
 */

/**
 * @create 2020-04-05 17:31
 * @desc many connection
 **/
package com.sd.lx.vector.ws.websock;


import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/websocket")
@Component
public class WebsockMany {

    private static DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final Logger LOGGER = Logger.getLogger(ToUpperWebsocket.class);
    private static ConcurrentHashMap<String, ConcurrentHashMap<String, WebsockMany>> roomList = new ConcurrentHashMap<>();
    private Session session;
    private int rejoin = 0;

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
    }

    //加入房间
    public void joinRoom(String roomId, String nickname){

        if (!roomList.containsKey(roomId)) {
            // 创建房间不存在时，创建房间
            ConcurrentHashMap<String, WebsockMany> room = new ConcurrentHashMap<>();
            // 添加用户
            room.put(nickname, this);
            roomList.put(roomId, room);
        } else {
            // 房间已存在，直接添加用户到相应的房间
            ConcurrentHashMap<String, WebsockMany> room = roomList.get(roomId);
            if (room.get(nickname) != null) {
                this.rejoin = 1;
            }else{
                room.put(nickname, this);
            }
            //发送消息给房间内的其他人，通知他们user已经上线
            for(String item : room.keySet()){
                Map<String, Object> map = new HashMap<>();
                map.put("flag", "joinRoom");
                map.put("name", item);
                map.put("status", "上线");
                room.get(item).sendMessage(map);
            }
        }
    }

    //发送消息
    public void sendMessage(Map<String, Object> map){
        JSONObject jsonObject = JSONObject.fromObject(map);
        try {
            // websocket  session发送文本消息有两个方法：
            // getAsyncRemote()和getBasicRemote() 推荐使用getAsyncRemote()这个方法
            // getBasicRemote是阻塞式的，getAsyncRemote是非阻塞式的
            // 。。。别问我，你在这里为什么使用getBasicRemote
            this.session.getBasicRemote().sendText(jsonObject.toString());
        } catch (IOException e) {
            LOGGER.error("sendMessage error occur [{}]",e);
        }
    }

    //接收来自用户的消息
    @OnMessage
    public void onMessage(String message, Session session) throws IOException{
        //把用户发来的消息解析成json对象
        JSONObject param = JSONObject.fromObject(message);
        //如果是退出房间 flag 分类：exitRoom 离开 joinRoom 加入房间 chatRoom 聊天
        String flag = (String)param.get("flag");

        // flag 可以定义两个类型 joinRoom(加入房间) ， existRoom(退出房间) 和 chatRoom （聊天）
        if(flag.equals("joinRoom")){
            // 用户名（必须保证唯一性）
            String nickname = param.getString("nickName");
            String roomId = param.getString("roomNo");
            this.joinRoom(roomId , nickname);
        }

        if(flag.equals("exitRoom")){
            String roomId = param.getString("roomId");
            String nickname = param.getString("nickname");
            ConcurrentHashMap<String, WebsockMany> room = roomList.get(roomId);//获取房间
            room.remove(nickname);//从房间中移除该用户
            //判断房间中是否有人，如果没人则删除房间，否则通知其他用户该用户已经下线
            if(room.size() == 0 ){
                roomList.remove(roomId);
            }else{
                for(String item : room.keySet()){
                    param.put("status", "下线");
                    room.get(item).sendMessage(param);
                }
            }
        }else if(flag.equals("chatRoom")){
            param.put("date", df.format(LocalDate.now()));
            String roomId = (String)param.get("roomId");
            String nickname = (String)param.get("nickname");
            ConcurrentHashMap<String, WebsockMany> room = roomList.get(roomId);
            if(room.get(nickname).rejoin == 0 ){
                for(String item: room.keySet()){
                    room.get(item).sendMessage(param);
                }
            }else{
                room.get(nickname).sendMessage(param);
            }
        }
    }

    //用户断开
    @OnClose
    public void onClose(Session session){
        boolean debug = LOGGER.isDebugEnabled();

        if (debug) {
            LOGGER.debug("closing......");
        }

        try {
            session.close();
        } catch (IOException e) {
            LOGGER.error("close websocket error occur [{}]",e);
        }
    }

    @OnError
    public void onError(Throwable t){
        LOGGER.error("webSocket data transfer error [{}]",t);
    }
}

