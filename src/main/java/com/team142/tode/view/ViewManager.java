/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.view;

import com.team142.tode.archive.controller.MessageManager;
import com.team142.tode.archive.model.messages.base.ViewType;
import com.team142.tode.archive.model.messages.outgoing.other.MessageChangeView;

/**
 * @author just1689
 */
public class ViewManager {

    public static void changePlayerView(String playerId, ViewType view) {
        MessageManager.sendPlayerAMessage(playerId, new MessageChangeView(view));
    }

}
