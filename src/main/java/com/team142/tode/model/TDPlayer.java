package com.team142.tode.model;

import com.team142.tode.archive.model.messages.outgoing.other.MessageChangeView;
import com.team142.tode.model.messages.BaseMessage;
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

    public void sendMessage(BaseMessage message) {
        if (session != null) {
            try {
                String json = JsonUtils.toJson(message);
                session.sendMessage(new TextMessage(json));
            } catch (Exception ex) {
                if (ex instanceof EOFException) {
                    TDServer.instance.playerDisconnects(this);
                }
            }
        }
    }

    public void handleMessage(String msg) {

    }

    public void changePlayerView(TDViewType view) {
        TDServer.instance.sendPlayerMessage(id, new MessageChangeView(view));
    }


}
