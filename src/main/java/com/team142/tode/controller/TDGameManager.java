package com.team142.tode.controller;

import com.team142.tode.model.TDGame;
import com.team142.tode.model.TDServer;
import com.team142.tode.model.TDViewType;

public class TDGameManager {

    public static void checkGame(TDGame game) {
        if (game.getPlayers().isEmpty()) {
            stopAndRemoveGame(game);
        }
    }

    public static void stopAndRemoveGame(TDGame game) {
        TDServer.instance.getGames().remove(game.getId());
        if (game.getMoneyTicker() != null) {
            game.getMoneyTicker().stop();
        }

    }

    public static void startGame(TDGame game) {
        //TODO: change the players views
        game.getPlayers().values().forEach((p) -> p.changePlayerView(TDViewType.GAMING));

        //TODO: send the map
        //...

        //TODO: start timers
        game.setMoneyTicker(new MoneyTicker(game, 1000));
        new Thread(game.getMoneyTicker()).start();

    }
}
