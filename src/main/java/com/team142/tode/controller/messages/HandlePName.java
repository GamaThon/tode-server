package com.team142.tode.controller.messages;

import com.team142.tode.controller.GameManager;
import com.team142.tode.model.Game;
import com.team142.tode.model.Player;
import com.team142.tode.model.Server;
import com.team142.tode.model.ViewType;
import com.team142.tode.model.messages.ConversationType;
import com.team142.tode.model.messages.MessagePName;
import com.team142.tode.model.messages.MessageSGames;
import com.team142.tode.model.messages.MessageSPlayerNumber;
import com.team142.tode.utils.JsonUtils;
import lombok.NoArgsConstructor;

import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
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

        int playerNumber;
        //TODO get a player to join a game.
        if (Server.instance.getGames().size() == 0) {
            Game game = Game.builder()
                    .id(UUID.randomUUID().toString())
                    .name(o.getName())
                    .players(new CopyOnWriteArrayList<>())
                    .map("default")
                    .build();
            boolean ok = game.playerJoins(player);
            if (!ok) {
                LOG.log(Level.SEVERE, "Unexpectedly can't join own game!");
                return;
            }

            playerNumber = 0;

            Server.instance.getGames().put(game.getId(), game);

        } else {

//            Iterator ite = Server.instance.getGames().entrySet().iterator();
//            while (ite.hasNext()) {
//                Map.Entry<String, Game> gameItem = (Map.Entry<String, Game>)ite.next();
//                if (gameItem.getValue().getPlayers().size() > 1) {
//                    continue;
//                }
//            }

            Game game = Server.instance.getGames().entrySet().iterator().next().getValue();
            boolean ok = game.playerJoins(player);
            if (!ok) {
                LOG.log(Level.INFO, "Could not join the game: ", game.getId());
                return;
            }

            playerNumber = 1;

            if (game.isReady()) {
                GameManager.startGame(game);

            } else {
                player.changePlayerView(ViewType.LOBBY);

            }
        }

        MessageSPlayerNumber messageSPlayerNumber = new MessageSPlayerNumber();
        messageSPlayerNumber.setPlayerNumber(playerNumber);
        messageSPlayerNumber.setConversationType(ConversationType.S_PLAYER_NUMBER);

        player.sendMessage(messageSPlayerNumber);

        MessageSGames response = new MessageSGames(Server.instance.getGames().values());
        player.sendMessage(response);

    }
}
