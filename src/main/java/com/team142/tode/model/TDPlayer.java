package com.team142.tode.model;

import com.team142.tode.controller.TDConnectionManager;
import com.team142.tode.model.messages.BaseMessage;
import com.team142.tode.model.messages.MessageSChangeView;
import com.team142.tode.utils.JsonUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.EOFException;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TDPlayer {

    private String id;
    private String name;
    private WebSocketSession session;
    private AtomicInteger money;

    public void sendMessage(BaseMessage message) {
        if (session != null) {
            try {
                String json = JsonUtils.toJson(message);
                session.sendMessage(new TextMessage(json));
            } catch (Exception ex) {
                if (ex instanceof EOFException) {
                    TDConnectionManager.playerDisconnects(this);
                }
            }
        }
    }

    public void changePlayerView(TDViewType view) {
        sendMessage(new MessageSChangeView(view));
    }


}
