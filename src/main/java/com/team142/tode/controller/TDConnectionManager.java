package com.team142.tode.controller;

import com.team142.tode.model.TDPlayer;
import com.team142.tode.model.TDServer;
import org.springframework.web.socket.WebSocketSession;

public class TDConnectionManager {

    public static void playerConnects(TDPlayer player) {
        TDServer.instance.getPlayers().put(player.getId(), player);
    }

    public void playerDisconnects(WebSocketSession session) {
        playerDisconnects(TDServer.instance.getPlayers().get(session.getId()));
    }

    public static void playerDisconnects(TDPlayer player) {
        TDServer.instance.getGames().forEachValue(2, (v) -> v.playerLeaves(player));
        TDServer.instance.getPlayers().remove(player.getId());
    }

}
