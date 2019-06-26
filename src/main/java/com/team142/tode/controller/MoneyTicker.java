package com.team142.tode.controller;

import com.team142.tode.model.TDGame;
import javafx.scene.paint.Stop;

import java.util.concurrent.atomic.AtomicBoolean;

public class MoneyTicker implements Runnable, Stoppable {

    private final TDGame game;
    private final long interval;
    private AtomicBoolean keepOnKeepingOn;

    public MoneyTicker(TDGame game, long interval) {
        this.game = game;
        this.interval = interval;
        this.keepOnKeepingOn = new AtomicBoolean(true);
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

    @Override
    public void stop() {
        this.keepOnKeepingOn.set(false);
    }
}
