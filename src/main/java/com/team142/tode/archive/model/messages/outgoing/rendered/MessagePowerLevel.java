/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.archive.model.messages.outgoing.rendered;

import com.team142.tode.archive.controller.runnable.powers.Power;
import com.team142.tode.archive.model.messages.base.ConversationType;
import com.team142.tode.model.messages.BaseMessage;
import lombok.Getter;

/**

 */
public class MessagePowerLevel extends BaseMessage {

    @Getter
    private String key;

    @Getter
    private int level;

    public MessagePowerLevel(Power power) {
        setConversation(ConversationType.S_P_LEVEL.name());
        this.key = String.valueOf(power.getKey());
        this.level = power.getLevel();
    }

}
