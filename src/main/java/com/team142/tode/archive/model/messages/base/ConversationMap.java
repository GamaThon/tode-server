/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.archive.model.messages.base;

import com.team142.tode.archive.model.messages.incoming.MessageJoinGame;
import com.team142.tode.archive.model.messages.incoming.MessageJoinServer;
import com.team142.tode.archive.model.messages.incoming.MessageKeyDown;
import com.team142.tode.archive.model.messages.incoming.MessageKeyUp;
import com.team142.tode.model.messages.ConversationType;

import java.util.HashMap;

/**

 */
public class ConversationMap {

    public static final HashMap<String, Class> MAP = new HashMap<String, Class>();

    static {
        MAP.put(ConversationType.P_REQUEST_JOIN_SERVER.name(), MessageJoinServer.class);
        MAP.put(ConversationType.P_REQUEST_JOIN_GAME.name(), MessageJoinGame.class);
        MAP.put(ConversationType.P_KD.name(), MessageKeyDown.class);
        MAP.put(ConversationType.P_KU.name(), MessageKeyUp.class);

    }

}
