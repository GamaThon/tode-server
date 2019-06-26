/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.archive.model.messages.outgoing.other;

import com.team142.tode.model.messages.ConversationType;
import com.team142.tode.model.messages.BaseMessage;
import lombok.Getter;

/**

 */
public class MessageCooldown extends BaseMessage {

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
