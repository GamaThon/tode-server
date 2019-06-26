package com.team142.tode.controller.messages;

import lombok.NoArgsConstructor;

import java.util.logging.Level;
import java.util.logging.Logger;

@NoArgsConstructor
public class HandlePSend implements Handler {
    private Logger LOG = Logger.getLogger(HandlePSend.class.getName());

    @Override
    public void handle(String sessionID, String msg) {
        LOG.log(Level.SEVERE, "handle Message P Send not implemented");
    }
}
