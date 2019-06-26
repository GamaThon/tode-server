package com.team142.tode.controller;

import com.team142.tode.model.TDGame;
import com.team142.tode.model.TDServer;

public class TDGameManager {

    public static void checkGame(TDGame game) {
        if (game.getPlayers().isEmpty()) {
            TDServer.instance.getGames().remove(game.getId());
        }
    }


}
