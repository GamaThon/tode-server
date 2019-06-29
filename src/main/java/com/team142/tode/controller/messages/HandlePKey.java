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
        LOG.log(Level.SEVERE, "handle Message P Key not implemented");

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

        //TODO move to dragon impl
        dragon.setHealth(1);
        dragon.setTicker(new CreepMovementTicker(30, dragon));
        dragon.setSpeed(0.5);

        dragon.setTag(0);
        dragon.setModel("");
        dragon.setSkin("");

        dragon.setPoint(spaceTimePoint);

        new Thread(dragon.getTicker()).start();

        player.sendMessage(MessageSPlayerCreep.builder().id(dragon.getId()).PlayerNumber(playerNumber).build());

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
