package com.team142.tode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team142.tode.controller.ticker.MoneyTicker;
import com.team142.tode.controller.GameManager;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.ConcurrentHashMap;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Game {

    private String id;
    private String name;

    @JsonIgnore
    private String map;
    @JsonIgnore
    private ConcurrentHashMap<String, Player> players;

    @JsonIgnore
    private MoneyTicker moneyTicker;

    public void playerLeaves(Player player) {
        players.remove(player.getId());
        GameManager.checkGame(this);
    }


    public boolean playerJoins(Player player) {
        if (players.size() > 2) {
            return false;
        }
        players.put(player.getId(), player);
        return true;
    }

    public boolean isReady() {
        return this.players.size() == 2;
    }

    public int getMoneyRate() {
        return 1; //TODO: how to handle this...
    }
}
