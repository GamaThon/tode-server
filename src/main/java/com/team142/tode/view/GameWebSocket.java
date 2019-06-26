/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.view;

import com.team142.tode.archive.model.Server;
import com.team142.tode.model.TDPlayer;
import com.team142.tode.model.TDServer;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.EOFException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author just1689
 */
public class GameWebSocket implements WebSocketHandler {

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        TDServer.handleMessage(session.getId(), message.getPayload());
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        TDPlayer player = TDPlayer.builder()
                .name("Unknown")
                .id(session.getId())
                .session(session)
                .build();
        TDServer.instance.playerConnects(player);

    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (!session.isOpen()) {
            TDServer.instance.playerDisconnects(session);
        }
        if (!(exception instanceof EOFException)) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, "Unknown Error at websocket:", exception);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        TDServer.instance.playerDisconnects(session);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
