/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.model;

import com.team142.tode.utils.EmptyChecker;

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
    public static final String REPORT_URL = "https://us-central1-good-game-192610.cloudfunctions.net/function-newPlayer-v1";
    public static final boolean DEBUG_ON = "TRUE".equals(System.getenv("DEBUG_ON"));
    public static final boolean IS_DEV = "dev".equals(System.getenv("REPORT_SERVER_STATS_AS"));
    public static final String REPORT_DS_FUNCTION_URL = "https://us-central1-good-game-192610.cloudfunctions.net/gg-function-server-capacity-v1";
    public static final String NOTIFY_PUSHOVER_USER = System.getenv("PUSHOVER_USER");
    public static final String NOTIFY_PUSHOVER_TOKEN = System.getenv("PUSHOVER_TOKEN");
    public static final boolean NOTIFY_PUSHOVER_ON_JOIN = !EmptyChecker.checkIfEmpty(NOTIFY_PUSHOVER_TOKEN) && !EmptyChecker.checkIfEmpty(NOTIFY_PUSHOVER_USER);
    public static final String NOTIFY_PUSHOVER_URL = "https://api.pushover.net/1/messages.json";
    public static final int MAX_PLAYERS_ON_SERVER = 40;
    public static String SERVER_NAME;
    public static boolean REPORT_STATS;

    public static int countPlayers() {
        return Repository.PLAYERS_ON_SERVER.values().size();
    }

}
