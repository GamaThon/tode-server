/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.view;

import com.team142.tode.model.TDServer;
import com.team142.tode.model.TDViewType;
import com.team142.tode.archive.model.messages.outgoing.other.MessageChangeView;

/**

 */
public class ViewManager {

    public static void changePlayerView(String playerId, TDViewType view) {
        TDServer.instance.sendPlayerMessage(playerId, new MessageChangeView(view));
    }

}
