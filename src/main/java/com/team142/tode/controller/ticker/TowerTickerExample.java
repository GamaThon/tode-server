package com.team142.tode.controller.ticker;

import com.team142.tode.model.TDGame;

public class TowerTickerExample extends BaseTower implements Stoppable {

    private static long initialTicker = 1000;
    private BaseTower tower;

    public TowerTickerExample(TDGame game, BaseTower tower) {
        super(game.getId(), initialTicker);
        this.tower = tower;
    }

    @Override
    public void handle() {
        //TODO: handle this particular type of tower shooting at things
    }

    public void stop() {
        this.getKeepOnKeepingOn().set(false);
    }
}
