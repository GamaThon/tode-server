/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.archive.controller.runnable.powers;

import com.team142.tode.archive.controller.GameManager;
import com.team142.tode.archive.model.Player;
import com.team142.tode.archive.model.Repository;

/**
 * @author just1689
 */
public class Power08Teleport extends Power {

    private static final long INITIAL_COOLDOWN = 10000;

    public Power08Teleport(Player player) {
        super(8, player, 0, INITIAL_COOLDOWN, 1, "8");
    }

    @Override
    public void execute() {
        GameManager.spawn(Repository.GAMES_ON_SERVER.get(getPlayer().getGameId()), getPlayer());

    }

    @Override
    public void nofityLevelChange() {
        setRefreshTime(INITIAL_COOLDOWN / getLevel());
    }

}
