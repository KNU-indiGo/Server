package com.example.indigo.websocket;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@Component
@Log4j2
public class PySocketHandler extends TextWebSocketHandler {
    private static List<WebSocketSession> list = new ArrayList<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
        String payload = message.getPayload();
        log.info("사람수 : " + payload);

        for(WebSocketSession sess: list){
            sess.sendMessage(message);
        }
    }

    /* method called when Client connect */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception{
        list.add(session);
        log.info(session + " Client connected");
    }

    /*method called when Client disconnect*/
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
        log.info(session + " Client disconnected");
        list.remove(session);
    }
}
