/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.archive.controller.runnable.powers;

import com.team142.tode.archive.model.Player;

/**
 * @author just1689
 */
public class Power09Hop180 extends Power {

    private static final long INITIAL_COOLDOWN = 10000;

    public Power09Hop180(Player player) {
        super(9, player, 0, INITIAL_COOLDOWN, 1, "9");
    }

    @Override
    public void execute() {
        getPlayer().getTANK().rotateLeft((float) Math.PI);

    }

    @Override
    public void nofityLevelChange() {
        setRefreshTime(INITIAL_COOLDOWN / getLevel());
    }

}
