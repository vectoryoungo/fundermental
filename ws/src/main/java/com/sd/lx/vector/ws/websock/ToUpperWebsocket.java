/*
 * module: fundermental
 * file: ToUpperWebsocket.java
 * date: 4/5/20 4:52 PM
 * author: VectorJu
 */

/*
 * module: fundermental
 * file: ToUpperWebsocket.java
 * date: 4/5/20 3:57 PM
 * author: VectorJu
 */

/**
 * @create 2020-04-05 15:57
 * @desc test websocket
 **/
package com.sd.lx.vector.ws.websock;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(value = "/toUpper")
@Component
public class ToUpperWebsocket {

    private static final Logger LOGGER = Logger.getLogger(ToUpperWebsocket.class);

    @OnOpen
    public void onOpen(Session session) {
        LOGGER.debug(String.format("WebSocket opened: %s", session.getId()));
    }

    @OnMessage
    public void onMessage(String txt, Session session) throws IOException {
        LOGGER.debug(String.format("Message received: %s", txt));
        session.getBasicRemote().sendText(txt.toUpperCase());
    }

    @OnClose
    public void onClose(CloseReason reason, Session session) {
        LOGGER.debug(String.format("Closing a WebSocket (%s) due to %s", session.getId(), reason.getReasonPhrase()));
    }

    @OnError
    public void onError(Session session, Throwable t) {
        LOGGER.error(String.format("Error in WebSocket session %s%n", session == null ? "null" : session.getId()), t);
    }

}

