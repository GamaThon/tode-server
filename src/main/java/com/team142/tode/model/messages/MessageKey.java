/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.model.messages;

import com.team142.tode.archive.model.messages.base.ConversationType;
import lombok.Getter;

/**
 *
 */
public class MessageKey extends BaseMessage {

    @Getter
    private String key;

    public MessageKey(ConversationType type) {
        setConversation(type.name());
    }

    public void setKey(String key) {
        this.key = key.toUpperCase();
    }

}
