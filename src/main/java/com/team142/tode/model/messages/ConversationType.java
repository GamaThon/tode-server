/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.model.messages;

/**

 */
public enum ConversationType {

    //FROM THE client app
    P_NAME,
    P_LIST,
    P_JOIN,
    P_NEW,
    P_PLACE,
    P_SEND,

    //From the server to the client
    S_GAMES,
    S_CHANGE_VIEW,
    S_MAP,
    S_SHARE_TAG,

//    S_SCOREBOARD,
//    S_PLAYER_LEFT,
//    S_SHARE_COOLDOWN,
//    S_P_LEVEL,
//    S_SHARE_RADAR,
//    S_SHARE_HEALTH,
//    S_SHARE_SPEECH

}
