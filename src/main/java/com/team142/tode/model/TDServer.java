package com.team142.tode.model;

import com.team142.tode.model.messages.BaseMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.socket.WebSocketSession;

import java.util.concurrent.ConcurrentHashMap;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TDServer {

    public static TDServer instance = TDServer.builder()
            .games(new ConcurrentHashMap<>())
            .build();

    public ConcurrentHashMap<String, TDGame> games;
    public ConcurrentHashMap<String, TDPlayer> players;

    public void handleMessage(String sessionId, String payload) {
        players.get(sessionId).handleMessage(payload);
    }

    public void playerConnects(TDPlayer player) {
        this.players.put(player.getId(), player);
    }

    public void playerDisconnects(WebSocketSession session) {
        playerDisconnects(instance.getPlayers().get(session.getId()));
    }

    public void playerDisconnects(TDPlayer player) {
        this.games.forEachValue(2, (v) -> v.playerLeaves(player));
        this.players.remove(player.getId());
    }

    public void sendPlayerMessage(String playerId, BaseMessage message) {
        getPlayers().get(playerId).sendMessage(message);
    }
}
