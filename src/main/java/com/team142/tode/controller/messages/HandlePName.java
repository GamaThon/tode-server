package com.team142.tode.controller.messages;

import com.team142.tode.model.Player;
import com.team142.tode.model.Server;
import com.team142.tode.model.ViewType;
import com.team142.tode.model.messages.MessagePName;
import com.team142.tode.utils.JsonUtils;
import lombok.NoArgsConstructor;

import java.util.logging.Level;
import java.util.logging.Logger;

@NoArgsConstructor
public class HandlePName implements Handler {
    private static final Logger LOG = Logger.getLogger(HandlePName.class.getName());

    @Override
    public void handle(String sessionID, String msg) {
        MessagePName o = (MessagePName) JsonUtils.jsonToObject(msg, MessagePName.class);
        LOG.log(Level.INFO, "Name is " + o.getName());
        Player player = Server.instance.getPlayers().get(sessionID);
        player.setName(o.getName());
        player.changePlayerView(ViewType.MATCHING);

    }
}
