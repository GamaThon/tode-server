package com.team142.tode.controller.messages;

public interface Handler {

    public void handle(String sessionID, String msg);

}
