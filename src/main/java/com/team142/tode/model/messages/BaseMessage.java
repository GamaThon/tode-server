/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.model.messages;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team142.tode.archive.model.messages.base.ConversationType;
import lombok.Data;
import lombok.NoArgsConstructor;

/**

 */
@NoArgsConstructor
@Data
public class BaseMessage {

    private String conversation;

    @JsonIgnore
    private String from;

    public void setConversationType(ConversationType type) {
        this.conversation = type.name();
    }

}
