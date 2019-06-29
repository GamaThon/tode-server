package com.team142.tode.controller.messages;

import com.team142.tode.controller.GameManager;
import com.team142.tode.model.Game;
import com.team142.tode.model.Player;
import com.team142.tode.model.Server;
import com.team142.tode.model.ViewType;
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
        Player me = Server.instance.getPlayers().get(sessionID);
        Game game = Server.instance.getGames().get(o.getId());
        boolean ok = game.playerJoins(me);
        if (!ok) {
            LOG.log(Level.INFO, "Could not join the game: ", o.getId());
            return;
        }

        if (game.isReady()) {
            GameManager.startGame(game);
        } else {
            me.changePlayerView(ViewType.LOBBY);

        }


    }
}
