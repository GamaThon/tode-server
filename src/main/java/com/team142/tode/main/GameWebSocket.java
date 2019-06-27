/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.main;


import com.team142.tode.controller.ConnectionManager;
import com.team142.tode.controller.RouterManager;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.EOFException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class GameWebSocket implements WebSocketHandler {

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        RouterManager.handle(session.getId(), (String) message.getPayload()); //TODO: does this work?
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        ConnectionManager.playerConnects(session);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (!session.isOpen()) {
            ConnectionManager.playerDisconnects(session);
        }
        if (!(exception instanceof EOFException)) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Unknown Error at websocket:", exception);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        ConnectionManager.playerDisconnects(session);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
