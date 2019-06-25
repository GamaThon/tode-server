/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.archive.controller;

import com.team142.tode.archive.controller.runnable.powers.Power;
import com.team142.tode.archive.model.Player;
import com.team142.tode.archive.model.Repository;
import com.team142.tode.model.messages.outgoing.other.MessageCooldown;
import com.team142.tode.model.messages.outgoing.rendered.MessagePowerLevel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author just1689
 */
public class PowerManager {

    private static final int CLIENT_COOLDOWN_TICK_MS = 20;

    public static void handle(Player player, String key) {
        Power power = player.getPowers().get(key);
        if (power != null) {
            power.run();
        }
    }

    public static void sendCooldown(String playerId, Power power, String key) {
        long ms = power.getRefreshTime() / CLIENT_COOLDOWN_TICK_MS;
        MessageCooldown message = new MessageCooldown((int) ms, key);
        MessageManager.sendPlayerAMessage(playerId, message);

    }

    public static void givePlayerPower(Player player, Power power) {
        player.addPower(power);
        MessageManager.sendPlayerAMessage(player.getId(), new MessagePowerLevel(power));

    }

    public static boolean givePlayerPowerLevel(Player player, Power power) {
        boolean incred = power.incrementLevel();
        if (incred) {
            power.nofityLevelChange();
            MessageManager.sendPlayerAMessage(player.getId(), new MessagePowerLevel(power));
        }
        return incred;
    }

    public static void givePlayerRandomPower(Player player) {
        boolean given = false;
        int size = Repository.POWER_CLASSES.size();
        int triesRemaining = 20;
        while (!given && triesRemaining > 0) {
            int nextInt = ThreadLocalRandom.current().nextInt(0, size);
            Power power = player.getPowers().get(String.valueOf(nextInt));
            boolean contains = power != null;
            if (contains) {
                boolean wasLeveled = givePlayerPowerLevel(player, power);
                if (wasLeveled) {
                    given = true;
                }
            } else {
                //Give power to player
                try {
                    Class powerClass = Repository.POWER_CLASSES.get(nextInt);
                    Constructor constructor = powerClass.getConstructor(new Class[]{Player.class});
                    power = (Power) constructor.newInstance(new Object[]{player});
                    givePlayerPower(player, power);
                    given = true;
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                    Logger.getLogger(PowerManager.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(PowerManager.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            triesRemaining--;
        }
        if (triesRemaining == 0) {
            System.err.println("Ran out of tries finding " + player.getName() + " a power!");
        }
    }

}
