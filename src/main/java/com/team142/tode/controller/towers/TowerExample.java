package com.team142.tode.controller.towers;

import com.team142.tode.model.TDGame;

public class TowerExample extends BaseTower {

    private static long initialTicker = 1000;

    public TowerExample(TDGame game) {
        super(game.getId(), initialTicker);
    }

    @Override
    public void handle() {
        //TODO: handle tower shooting at things
    }
}
