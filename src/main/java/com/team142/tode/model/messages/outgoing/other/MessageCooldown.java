/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.model.messages.outgoing.other;

import com.team142.tode.model.messages.base.ConversationType;
import com.team142.tode.model.messages.base.Message;
import lombok.Getter;

/**
 * @author just1689
 */
public class MessageCooldown extends Message {

    @Getter
    private int ticks;

    @Getter
    private String key;

    public MessageCooldown(int ticks, String key) {
        setConversation(ConversationType.S_SHARE_COOLDOWN.name());
        this.ticks = ticks;
        this.key = key;

    }

}
