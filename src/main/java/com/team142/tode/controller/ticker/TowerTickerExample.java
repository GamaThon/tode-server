package com.team142.tode.controller.ticker;

import com.team142.tode.model.TDGame;

public class TowerTickerExample extends BaseTower {

    private static long initialTicker = 1000;

    public TowerTickerExample(TDGame game) {
        super(game.getId(), initialTicker);
    }

    @Override
    public void handle() {
        //TODO: handle tower shooting at things
    }
}
