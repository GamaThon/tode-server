package com.team142.tode.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.ConcurrentHashMap;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TDServer {

    private static TDServer instance = TDServer.builder()
            .games(new ConcurrentHashMap<>())
            .build();

    public ConcurrentHashMap<String, TDGame> games;
    public ConcurrentHashMap<String, TDPlayer> players;

    public void playerConnects(TDPlayer player) {
        this.players.put(player.getId(), player);
    }

    public void playerDisconnects(TDPlayer player) {
        this.games.forEachValue(10, (v) -> v.playerLeaves(player));
        this.players.remove(player.getId());
    }


}
