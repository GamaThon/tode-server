/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.model.messages;

import com.team142.tode.model.ViewType;

import static com.team142.tode.model.messages.ConversationType.S_CHANGE_VIEW;

/**
 *
 */
public class MessageSChangeView extends BaseMessage {

    private final ViewType view;

    public MessageSChangeView(ViewType view) {
        this.view = view;
        setConversation(S_CHANGE_VIEW.name());

    }

}
