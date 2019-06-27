package com.team142.tode.controller;

import com.team142.tode.model.Player;
import com.team142.tode.model.Server;
import org.springframework.web.socket.WebSocketSession;

import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionManager {

    public static void playerConnects(WebSocketSession session) {
        Player player = Player.builder()
                .name("Unknown")
                .id(session.getId())
                .session(session)
                .money(new AtomicInteger(0))
                .build();
        playerConnects(player);
    }


    private static void playerConnects(Player player) {
        Server.instance.getPlayers().put(player.getId(), player);
    }

    public static void playerDisconnects(WebSocketSession session) {
        playerDisconnects(Server.instance.getPlayers().get(session.getId()));
    }

    public static void playerDisconnects(Player player) {
        Server.instance.getGames().forEachValue(2, (v) -> v.playerLeaves(player));
        Server.instance.getPlayers().remove(player.getId());
    }

}
