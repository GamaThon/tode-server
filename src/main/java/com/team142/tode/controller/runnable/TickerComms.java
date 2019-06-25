/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.controller.runnable;

import com.team142.tode.controller.MessageManager;
import com.team142.tode.controller.runnable.base.AbstractTickerWorker;
import com.team142.tode.model.Repository;
import com.team142.tode.model.messages.outgoing.rendered.MessageShareThingsDynamic;

/**
 * @author just1689
 */
public class TickerComms extends AbstractTickerWorker {

    private long lastPing = 0;

    public TickerComms(String playerId, String gameId) {
        super(playerId, gameId);
    }

    @Override
    public void doTick() {
        checkPing();
        MessageManager.sendPlayerAMessage(getPLAYER_ID(), getDynamicThingsMessage());

    }

    private MessageShareThingsDynamic getDynamicThingsMessage() {
        return new MessageShareThingsDynamic(Repository.GAMES_ON_SERVER.get(getGAME_ID()));
    }

    private void checkPing() {
        if (lastPing == 0) {
            ping();
        }

    }

    public void ping() {
        MessageManager.sendPlayerAMessage(Repository.SESSIONS_ON_SERVER.get(getPLAYER_ID()), "0");
        lastPing = System.currentTimeMillis();

    }

    public void pong() {
        //
    }

}
