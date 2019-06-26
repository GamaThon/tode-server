package com.team142.tode.model;

import com.team142.tode.archive.controller.ServerManager;
import com.team142.tode.model.messages.base.Message;
import com.team142.tode.utils.JsonUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.EOFException;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TDPlayer {

    private String id;
    private String name;
    private WebSocketSession session;

    public void sendMessage(Message message) {
        String json = JsonUtils.toJson(message);
        if (session != null) {
            try {
                session.sendMessage(new TextMessage(json));
            } catch (Exception ex) {
                if (ex instanceof EOFException) {
                    ServerManager.checkSession(session);
                }
            }
        }
    }
}
