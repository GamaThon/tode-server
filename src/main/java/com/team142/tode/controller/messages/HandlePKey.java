package com.team142.tode.controller.messages;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HandlePKey implements Handler {
    private Logger LOG = Logger.getLogger(HandlePKey.class.getName());

    @Override
    public void handle(String sessionID, String msg) {
        LOG.log(Level.SEVERE, "handle Message P Key not implemented");
    }
}
