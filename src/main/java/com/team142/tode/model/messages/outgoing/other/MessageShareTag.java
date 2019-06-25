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
public class MessageShareTag extends Message {

    @Getter
    private int tag;

    public MessageShareTag(int tag) {
        setConversation(ConversationType.S_SHARE_TAG.name());
        this.tag = tag;

    }

}
