package com.team142.tode.archive.model.messages.outgoing.rendered;

import com.team142.tode.archive.model.messages.base.ConversationType;
import com.team142.tode.model.messages.BaseMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Data
public class MessageSpeech extends BaseMessage {

    @Getter
    private String text;

    public MessageSpeech(String text) {
        this.setConversation(ConversationType.S_SHARE_SPEECH.name());
        this.text = text;
    }

}
