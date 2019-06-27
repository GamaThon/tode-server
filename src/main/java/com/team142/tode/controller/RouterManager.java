package com.team142.tode.controller;

import com.team142.tode.controller.messages.*;
import com.team142.tode.model.messages.BaseMessage;
import com.team142.tode.model.messages.ConversationType;
import com.team142.tode.utils.JsonUtils;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * RouterManager handles incoming messages and finds a class to handle the Conversation
 */
public class RouterManager {

    private static final Logger LOG = Logger.getLogger(RouterManager.class.getName());

    private static final HashMap<String, Handler> ROUTES = new HashMap<>();

    static {
        ROUTES.put(ConversationType.P_NAME.name(), new HandlePName());
        ROUTES.put(ConversationType.P_NEW.name(), new HandlePNew());
        ROUTES.put(ConversationType.P_JOIN.name(), new HandlePJoin());
        ROUTES.put(ConversationType.P_LIST.name(), new HandlePList());
        ROUTES.put(ConversationType.P_PLACE.name(), new HandlePPlace());
        ROUTES.put(ConversationType.P_SEND.name(), new HandlePSend());

    }

    public static void handle(String sessionID, String message) {
        BaseMessage o = (BaseMessage) JsonUtils.jsonToObject(message, BaseMessage.class);
        if (o == null) {
            LOG.log(Level.SEVERE, "Could not handle message: " + message);
            return;
        }
        handle(o.getConversation(), sessionID, message);

    }

    public static void handle(String conversation, String sessionID, String message) {
        Handler h = ROUTES.get(conversation);
        if (h == null) {
            LOG.log(Level.SEVERE, "Could not handle conversation: " + conversation);
            return;
        }
        h.handle(sessionID, message);
    }


}
