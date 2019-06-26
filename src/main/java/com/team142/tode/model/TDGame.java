package com.team142.tode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team142.tode.controller.ticker.MoneyTicker;
import com.team142.tode.controller.TDGameManager;
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
    private String name;

    @JsonIgnore
    private String map;
    @JsonIgnore
    private ConcurrentHashMap<String, TDPlayer> players;

    @JsonIgnore
    private MoneyTicker moneyTicker;

    public void playerLeaves(TDPlayer player) {
        players.remove(player.getId());
        TDGameManager.checkGame(this);
    }


    public boolean playerJoins(TDPlayer player) {
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
