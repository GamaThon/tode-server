package com.team142.tode.controller.ticker;

import com.team142.tode.model.BaseCreep;
import com.team142.tode.model.Game;

public class CreepMovementTicker extends Ticker {
    private BaseCreep baseCreep;

    public CreepMovementTicker(long interval, BaseCreep baseCreep) {
        super(interval);
        this.baseCreep = baseCreep;
    }

    @Override
    public void handle() {
        double speed = baseCreep.getSpeed();
        //TODO do movement at speed
//        baseCreep.getPoint().
    }

}
