/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.archive.model;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author just1689
 */
public class Server {

    public static final int TICK_MS = 17;
    public static final double DEFAULT_SPEED = 0.125;
    public static final double TANK_DEFAULT_SPEED = 0.05;
    public static final double BULLET_DEFAULT_SPEED = 0.25;
    public static final double BULLET_INCREMENT_SPEED = 0.05;
    public static final AtomicInteger TAGS = new AtomicInteger(1000);
    public static final boolean DEBUG_ON = "TRUE".equals(System.getenv("DEBUG_ON"));
    public static final int MAX_PLAYERS_ON_SERVER = 40;
    public static String SERVER_NAME;
    public static boolean REPORT_STATS;

    public static int countPlayers() {
        return Repository.PLAYERS_ON_SERVER.values().size();
    }

}
