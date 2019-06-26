/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.archive.model.messages.outgoing.other;

import com.team142.tode.model.messages.ConversationType;
import com.team142.tode.archive.model.messages.base.SoundType;
import com.team142.tode.model.messages.BaseMessage;
import lombok.Getter;

/**

 */
public class MessagePlaySound extends BaseMessage {

    @Getter
    private final String FILE;

    public MessagePlaySound(SoundType type) {
        setConversation(ConversationType.S_PLAY_SOUND.name());
        this.FILE = type.getFILE();

    }

}
