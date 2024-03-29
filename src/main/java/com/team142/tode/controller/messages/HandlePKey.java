package com.team142.tode.controller.messages;

import com.team142.tode.controller.ticker.CreepMovementTicker;
import com.team142.tode.model.*;
import com.team142.tode.model.map.SpaceTimePoint;
import com.team142.tode.model.messages.MessageSPlayerCreep;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HandlePKey implements Handler {
    private Logger LOG = Logger.getLogger(HandlePKey.class.getName());

    @Override
    public void handle(String sessionID, String msg) {
        LOG.log(Level.SEVERE, "Sending creep");
        keyDown(sessionID);

    }

    public void keyDown(String sessionID) {

        Player player = Server.instance.getPlayers().get(sessionID);
        Game game = Server.instance.getGames().entrySet().iterator().next().getValue();

        int playerNumber = 0;

        if(!game.getPlayers().get(0).getId().equalsIgnoreCase(player.getId())) {
            playerNumber = 1;
        }

        SpaceTimePoint spaceTimePoint = getSpaceTimePoint(playerNumber);

        Dragon dragon = new Dragon();

        dragon.setId(UUID.randomUUID().toString());
        dragon.setGameId(game.getId());

        dragon.setOwner(sessionID);

        dragon.setTag(0);
        dragon.setModel("");
        dragon.setSkin("");

        dragon.setPoint(spaceTimePoint);

        new Thread(dragon.getTicker()).start();

        MessageSPlayerCreep messageSPlayerCreep = new MessageSPlayerCreep();
        messageSPlayerCreep.setId(dragon.getId());
        messageSPlayerCreep.setPlayerNumber(playerNumber);

        game.getPlayers().forEach(
                (p) -> player.sendMessage(messageSPlayerCreep)
        );

    }

//    private SpaceTimePoint getSpaceTimePoint(String sessionID) {
    private SpaceTimePoint getSpaceTimePoint(int playerNumber) {
        SpaceTimePoint spaceTimePoint;
        if(playerNumber == 0) {
            spaceTimePoint = new SpaceTimePoint(20, 160);
        } else {
            spaceTimePoint = new SpaceTimePoint(300, 160);
        }
        spaceTimePoint.setY(8);
        return spaceTimePoint;
    }
}
