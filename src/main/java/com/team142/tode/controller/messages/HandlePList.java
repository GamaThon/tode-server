package com.team142.tode.controller.messages;

import com.team142.tode.model.Server;
import com.team142.tode.model.messages.MessageSGames;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HandlePList implements Handler {
    @Override
    public void handle(String sessionID, String msg) {
        MessageSGames message = new MessageSGames(Server.instance.getGames().values());
        Server.instance.getPlayers().get(sessionID).sendMessage(message);
    }
}
