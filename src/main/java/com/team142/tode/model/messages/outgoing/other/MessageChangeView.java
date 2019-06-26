/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.model.messages.outgoing.other;

import com.team142.tode.model.TDViewType;
import com.team142.tode.model.messages.base.Message;
import com.team142.tode.model.messages.base.ViewType;

import static com.team142.tode.model.messages.base.ConversationType.S_CHANGE_VIEW;

/**
 * @author just1689
 */
public class MessageChangeView extends Message {

    private final TDViewType view;

    public MessageChangeView(TDViewType view) {
        this.view = view;
        setConversation(S_CHANGE_VIEW.name());

    }

}
