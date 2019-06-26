/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.archive.model.messages.outgoing.other;

import com.team142.tode.model.TDViewType;
import com.team142.tode.model.messages.BaseMessage;

import static com.team142.tode.archive.model.messages.base.ConversationType.S_CHANGE_VIEW;

/**

 */
public class MessageChangeView extends BaseMessage {

    private final TDViewType view;

    public MessageChangeView(TDViewType view) {
        this.view = view;
        setConversation(S_CHANGE_VIEW.name());

    }

}
