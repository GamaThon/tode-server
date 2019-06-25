/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.model.messages.incoming;

import com.team142.tode.archive.controller.PlayerManager;
import com.team142.tode.model.messages.base.ConversationType;
import com.team142.tode.model.messages.base.MessageKey;

/**
 * @author just1689
 */
public class MessageKeyDown extends MessageKey implements Runnable {

    public MessageKeyDown() {
        super(ConversationType.P_KD);
    }

    @Override
    public void run() {
        PlayerManager.handle(this);
    }

}
