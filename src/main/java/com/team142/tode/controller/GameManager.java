package com.team142.tode.controller;

import com.team142.tode.controller.ticker.MoneyTicker;
import com.team142.tode.model.Game;
import com.team142.tode.model.Server;
import com.team142.tode.model.ViewType;

public class GameManager {

    public static void checkGame(Game game) {
        if (game.getPlayers().isEmpty()) {
            stopAndRemoveGame(game);
        }
    }

    public static void stopAndRemoveGame(Game game) {
        Server.instance.getGames().remove(game.getId());
        if (game.getMoneyTicker() != null) {
            game.getMoneyTicker().stop();
        }

    }

    public static void startGame(Game game) {
        //TODO: change the players views
        game.getPlayers().values().forEach((p) -> p.changePlayerView(ViewType.GAMING));

        //TODO: send the map
        //...

        //TODO: start timers
        game.setMoneyTicker(new MoneyTicker(1000, game));
        new Thread(game.getMoneyTicker()).start();

    }
}
