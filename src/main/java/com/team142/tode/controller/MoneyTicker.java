package com.team142.tode.controller;

import com.team142.tode.model.TDGame;

import java.util.concurrent.atomic.AtomicBoolean;

public class MoneyTicker implements Runnable {

    private final TDGame game;
    private final long interval;
    private AtomicBoolean keepOnKeepingOn;

    public MoneyTicker(TDGame game, long interval) {
        this.game = game;
        this.interval = interval;
    }

    @Override
    public void run() {
        while (keepOnKeepingOn.get()) {
            int m = game.getMoneyRate();
            game.getPlayers().values().forEach((p) -> p.getMoney().addAndGet(m));
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.keepOnKeepingOn.set(false);
    }
}
