package com.team142.tode.controller.ticker;


import com.team142.tode.model.Game;

public class MoneyTicker extends Ticker {

    private Game game;

    public MoneyTicker(long interval, Game game) {
        super(interval);
        this.game = game;
    }

    @Override
    public void handle() {
        int m = game.getMoneyRate();
        game.getPlayers().
                forEach(
                        (p) -> p.getMoney().addAndGet(m)
                );
    }

}
