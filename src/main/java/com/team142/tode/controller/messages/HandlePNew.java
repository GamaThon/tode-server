package com.team142.tode.controller.messages;

import com.team142.tode.model.Game;
import com.team142.tode.model.Player;
import com.team142.tode.model.Server;
import com.team142.tode.model.ViewType;
import com.team142.tode.model.messages.MessagePName;
import com.team142.tode.utils.JsonUtils;
import lombok.NoArgsConstructor;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@NoArgsConstructor
public class HandlePNew implements Handler {
    private static final Logger LOG = Logger.getLogger(HandlePNew.class.getName());

    @Override
    public void handle(String sessionID, String msg) {
        Player me = Server.instance.getPlayers().get(sessionID);
        MessagePName o = (MessagePName) JsonUtils.jsonToObject(msg, MessagePName.class);
        Game game = Game.builder()
                .id(UUID.randomUUID().toString())
                .name(o.getName())
                .players(new ConcurrentHashMap<>())
                .map("default")
                .build();
        boolean ok = game.playerJoins(me);
        if (!ok) {
            LOG.log(Level.SEVERE, "Unexpectedly cant join own game!");
            return;
        }
        me.changePlayerView(ViewType.LOBBY);

    }
}
