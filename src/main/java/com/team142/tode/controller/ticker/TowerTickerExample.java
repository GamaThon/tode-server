package com.team142.tode.controller.ticker;


import com.team142.tode.model.BaseTower;

public class TowerTickerExample extends Ticker {

    private BaseTower tower;

    public TowerTickerExample(long interval, BaseTower tower) {
        super(interval);
        this.tower = tower;
    }

    @Override
    public void handle() {

        tower.getDamage();
        tower.getLevel();
        tower.getGameId();

        //TODO: attack things?
    }
}
