package com.team142.tode.controller.messages;

import com.team142.tode.model.TDPlayer;
import com.team142.tode.model.TDServer;
import com.team142.tode.model.TDViewType;
import com.team142.tode.model.messages.MessagePJoin;
import com.team142.tode.utils.JsonUtils;
import lombok.NoArgsConstructor;

import java.util.logging.Level;
import java.util.logging.Logger;

@NoArgsConstructor
public class HandlePJoin implements Handler {

    private static final Logger LOG = Logger.getLogger(HandlePJoin.class.getName());

    @Override
    public void handle(String sessionID, String msg) {
        MessagePJoin o = (MessagePJoin) JsonUtils.jsonToObject(msg, MessagePJoin.class);
        TDPlayer me = TDServer.instance.getPlayers().get(sessionID);
        boolean ok = TDServer.instance.getGames().get(o.getId()).playerJoins(me);
        if (!ok) {
            LOG.log(Level.INFO, "Could not join the game: ", o.getId());
            return;
        }
        me.changePlayerView(TDViewType.LOBBY);

    }
}
