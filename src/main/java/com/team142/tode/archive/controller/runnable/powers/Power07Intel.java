/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.archive.controller.runnable.powers;

import com.team142.tode.archive.controller.GameManager;
import com.team142.tode.archive.controller.MessageManager;
import com.team142.tode.archive.model.Game;
import com.team142.tode.archive.model.Player;
import com.team142.tode.archive.model.Repository;
import com.team142.tode.model.messages.outgoing.other.MessageIntelChange;

import java.util.logging.Level;
import java.util.logging.Logger;

/**

 */
public class Power07Intel extends Power {

    private static final int INITIAL_COOLDOWN = 5000;
    private final Game game;

    public Power07Intel(Player player) {
        super(7, player, 0, INITIAL_COOLDOWN, 1, "7");
        game = Repository.GAMES_ON_SERVER.get(getPlayer().getGameId());
    }

    @Override
    public void execute() {
        MessageIntelChange message = new MessageIntelChange(true);
        MessageManager.sendPlayerAMessage(getPlayer().getId(), message);

        notifyHP();

        new Thread(() -> {
            try {
                Thread.sleep(getRefreshTime());
                MessageIntelChange message1 = new MessageIntelChange(false);
                MessageManager.sendPlayerAMessage(getPlayer().getId(), message1);
                notifyHP();

            } catch (InterruptedException ex) {
                Logger.getLogger(Power07Intel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();

    }

    @Override
    public void nofityLevelChange() {
        setRefreshTime(INITIAL_COOLDOWN * getLevel());
    }

    private void notifyHP() {
        new Thread(() -> {
            game
                    .getPlayers()
                    .forEach(e -> GameManager.notifyHealthChange(getPlayer(), e.getTANK()));
        }).start();

    }
}
