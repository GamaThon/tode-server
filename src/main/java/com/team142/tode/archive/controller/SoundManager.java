/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.archive.controller;

import com.team142.tode.archive.model.Player;
import com.team142.tode.archive.model.Repository;
import com.team142.tode.archive.model.messages.base.SoundType;
import com.team142.tode.archive.model.messages.outgoing.other.MessagePlaySound;
import com.team142.tode.archive.model.messages.outgoing.rendered.MessageSpeech;
import lombok.AllArgsConstructor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**

 */
@AllArgsConstructor
public class SoundManager {

    public final Executor SOUND_MSG_THREAD_POOL = Executors.newFixedThreadPool(4, (Runnable r) -> {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    });
    private final String GAME_ID;

    public void sendSpeech(String text) {
        SOUND_MSG_THREAD_POOL.execute(() -> MessageManager.sendPlayersAMessage(Repository.GAMES_ON_SERVER.get(GAME_ID), new MessageSpeech(text)));
    }

    public void sendSpeechOnce(Player player, String text) {
        if (player.haveIHeard(text)) {
            return;
        }
        SOUND_MSG_THREAD_POOL.execute(() -> MessageManager.sendPlayerAMessage(player.getId(), new MessageSpeech(text)));
    }


    public void sendSound(SoundType type) {
        SOUND_MSG_THREAD_POOL.execute(() -> MessageManager.sendPlayersAMessage(Repository.GAMES_ON_SERVER.get(GAME_ID), new MessagePlaySound(type)));
    }

    public void sendShoot() {
        sendSound(SoundType.PEW);

    }

    public void sendDing() {
        sendSound(SoundType.DING);

    }

    public void sendExplode() {
        sendSound(SoundType.EXPLODE);

    }

    public void sendSpawn() {
        sendSound(SoundType.SHHHA);

    }

    public void sendDoubleKill() {
        sendSound(SoundType.X2);
    }

    public void sendTripleKill() {
        sendSound(SoundType.X3);
    }

    public void sendQuadKill() {
        sendSound(SoundType.X4);
    }

    public void sendPentaKill() {
        sendSound(SoundType.X5);
    }

    public void sendNie() {
        sendSound(SoundType.NIE);
    }

    public void sendYipee() {
        sendSound(SoundType.YIPEE);
    }

}
