package com.team142.tode.model;

import com.team142.tode.controller.ticker.CreepMovementTicker;
import lombok.Data;

@Data
public class Dragon extends BaseCreep {

    public String roar;

    public Dragon() {
        super();
        this.setHealth(1);
        this.setTicker(new CreepMovementTicker(30, this));
        this.setSpeed(0.5);
    }

}
