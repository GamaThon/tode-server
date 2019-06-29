package com.team142.tode.model.messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MessageSPlayerCreep extends BaseMessage {

    private String id;
    private int PlayerNumber;

    public MessageSPlayerCreep() {
        this.setConversationType(ConversationType.S_PLAYER_CREEP);
    }
}
