/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.archive.model;

import com.team142.tode.archive.controller.GameManager;
import com.team142.tode.archive.controller.MessageManager;
import com.team142.tode.archive.controller.SoundManager;
import com.team142.tode.archive.controller.runnable.TickerPing;
import com.team142.tode.archive.model.mappable.artificial.Tank;
import com.team142.tode.archive.model.messages.outgoing.other.MessageGameSummary;
import com.team142.tode.archive.model.messages.outgoing.other.MessagePlayerLeft;
import lombok.Data;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author just1689
 * <p>
 * A game will be where game state is managed.
 */
@Data
public class Game {

    private final String id;
    private final String name;
    private final List<Player> players = new CopyOnWriteArrayList<>();
    private final ConcurrentHashMap<String, Tank> TANKS = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Orb> orbs = new ConcurrentHashMap<>();
    private GameMap map;
    private SoundManager soundManager;
    private Thread pingThread;

    private double startHealth;

    private AtomicInteger GAME_COUNTER = new AtomicInteger(0);

    public Game(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;

        this.soundManager = new SoundManager(this.id);

        this.startHealth = 100;
        startPinger();

    }

    public MessageGameSummary toGameSummary() {
        return new MessageGameSummary(id, name, players.size());
    }

    public boolean hasPlayer(String id) {
        return players.stream().anyMatch((player) -> (player.getId().equals(id)));
    }

    public void removePlayer(Player player) {
        TANKS.remove(player.getId());
        MessageManager.sendPlayersAMessage(this, new MessagePlayerLeft(player.getTAG()));
        players.removeIf(playerItem -> playerItem.getId().equals(player.getId()));
        GameManager.sendScoreBoard(this);

    }

    private void startPinger() {
        this.pingThread = new Thread(new TickerPing(players));
        pingThread.start();
    }

}
