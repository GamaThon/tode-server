package com.team142.tode.controller.towers;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class BaseTower implements Runnable {

    private String gameID;
    private AtomicBoolean keepOnKeepingOn;
    private long ticker;
    private int level;

    public BaseTower(String gid, long ticker) {
        this.gameID = gid;
        this.ticker = ticker;
        this.keepOnKeepingOn = new AtomicBoolean(true);
        this.level = 1;
    }

    public abstract void handle();

    @Override
    public void run() {
        while (keepOnKeepingOn.get()) {
            handle();
            try {
                Thread.sleep(ticker);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}