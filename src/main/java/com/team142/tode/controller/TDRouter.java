package com.team142.tode.controller;

import com.team142.tode.controller.messages.*;
import com.team142.tode.model.messages.BaseMessage;
import com.team142.tode.model.messages.ConversationType;
import com.team142.tode.utils.JsonUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TDRouter handles incoming messages and finds a class to handle the Conversation
 */
public class TDRouter {

    private static final Logger LOG = Logger.getLogger(TDRouter.class.getName());

    private static final HashMap<String, Class> ROUTES = new HashMap<>();

    static {
        ROUTES.put(ConversationType.P_NAME.name(), HandlePName.class);
        ROUTES.put(ConversationType.P_NEW.name(), HandlePNew.class);
        ROUTES.put(ConversationType.P_JOIN.name(), HandlePJoin.class);
        ROUTES.put(ConversationType.P_LIST.name(), HandlePList.class);
        ROUTES.put(ConversationType.P_PLACE.name(), HandlePPlace.class);
        ROUTES.put(ConversationType.P_SEND.name(), HandlePSend.class);

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
        Class c = ROUTES.get(conversation);
        if (c == null) {
            LOG.log(Level.SEVERE, "Could not handle conversation: " + conversation);
            return;
        }
        try {
            Handler o = (Handler) c.getDeclaredConstructor().newInstance();
            o.handle(sessionID, message);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
