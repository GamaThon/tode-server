package com.team142.tode.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.ConcurrentHashMap;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TDGame {

    private String id;
    private String title;
    private String map;
    private ConcurrentHashMap<String, TDPlayer> players;

    public void playerLeaves(TDPlayer player) {
        players.remove(player.getId());
    }

    public boolean playerJoins(TDPlayer player) {
        if (players.size() < 2) {
            players.put(player.getId(), player);
            return true;
        }
        return false;
    }

}
