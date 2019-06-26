package com.team142.tode.controller.messages;

import com.team142.tode.model.TDServer;
import com.team142.tode.model.messages.MessagePName;
import com.team142.tode.utils.JsonUtils;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HandlePName implements Handler {
    @Override
    public void handle(String sessionID, String msg) {
        MessagePName o = (MessagePName) JsonUtils.jsonToObject(msg, MessagePName.class);
        TDServer.instance.getPlayers().get(sessionID).setName(o.getName());
    }
}
