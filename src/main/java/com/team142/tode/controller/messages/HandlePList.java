package com.team142.tode.controller.messages;

import com.team142.tode.model.TDServer;
import com.team142.tode.model.messages.MessageSGames;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HandlePList implements Handler {
    @Override
    public void handle(String sessionID, String msg) {
        MessageSGames message = new MessageSGames(TDServer.instance.getGames().values());
        TDServer.instance.getPlayers().get(sessionID).sendMessage(message);
    }
}
