/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.archive.model.messages.incoming;

import com.team142.tode.archive.controller.PlayerManager;
import com.team142.tode.archive.model.messages.base.ConversationType;
import com.team142.tode.archive.model.messages.base.MessageKey;

/**

 */
public class MessageKeyUp extends MessageKey implements Runnable {

    public MessageKeyUp() {
        super(ConversationType.P_KU);
    }

    @Override
    public void run() {
        PlayerManager.handle(this);

    }

}
