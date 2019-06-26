package com.team142.tode.controller;

import com.team142.tode.model.TDServer;
import com.team142.tode.model.TDViewType;
import com.team142.tode.model.messages.MessageSChangeView;

public class TDViewManager {

    public static void changePlayerView(String playerId, TDViewType view) {
        TDServer.instance.getPlayers().get(playerId).sendMessage(new MessageSChangeView(view));
    }

}
