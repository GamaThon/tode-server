/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.archive.controller;

import com.team142.tode.archive.model.Player;
import com.team142.tode.archive.model.Repository;
import com.team142.tode.model.messages.incoming.MessageKeyDown;
import com.team142.tode.model.messages.incoming.MessageKeyUp;

/**

 */
public class PlayerManager {

    public static void handle(MessageKeyDown message) {
        PlayerManager.keyDown(Repository.PLAYERS_ON_SERVER.get(message.getFrom()), message.getKey());
    }

    public static void keyDown(Player player, String key) {
        char c = key.charAt(0);
        if ((c >= '0' && c <= '9') || c == ' ') {
            PowerManager.handle(player, key);
            return;
        }
        player.keyDown(key);
    }

    public static void handle(MessageKeyUp message) {
        PlayerManager.keyUp(Repository.PLAYERS_ON_SERVER.get(message.getFrom()), message.getKey());
    }

    public static void keyUp(Player player, String key) {
        player.keyUp(key);
    }

}
