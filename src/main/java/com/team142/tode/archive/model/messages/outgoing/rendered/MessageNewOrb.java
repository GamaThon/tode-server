/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.archive.model.messages.outgoing.rendered;

import com.team142.tode.archive.model.Orb;
import com.team142.tode.model.messages.ConversationType;
import com.team142.tode.model.messages.BaseMessage;
import lombok.Getter;

/**

 */
public class MessageNewOrb extends BaseMessage {

    @Getter
    private String name;

    @Getter
    private double x, z;

    public MessageNewOrb(Orb orb) {
        setConversation(ConversationType.S_ORB_N.name());
        this.name = orb.getName();
        this.x = orb.getPoint().getX();
        this.z = orb.getPoint().getZ();
    }

}
