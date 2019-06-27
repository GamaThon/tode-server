package com.team142.tode.controller.ticker;


import lombok.Data;

import java.util.concurrent.atomic.AtomicBoolean;

@Data
public abstract class Ticker implements Runnable, Stoppable {

    private AtomicBoolean keepOnKeepingOn;
    private long interval;

    public Ticker(long interval) {
        this.interval = interval;
        this.keepOnKeepingOn = new AtomicBoolean(true);
    }

    public abstract void handle();

    @Override
    public void run() {
        while (keepOnKeepingOn.get()) {
            handle();
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
