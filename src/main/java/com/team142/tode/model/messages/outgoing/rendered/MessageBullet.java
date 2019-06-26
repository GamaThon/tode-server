/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.model.messages.outgoing.rendered;

import com.team142.tode.model.messages.base.ConversationType;
import com.team142.tode.model.messages.base.Message;
import lombok.Getter;

/**

 */
public class MessageBullet extends Message {

    @Getter
    private final Bullet BULLET;

    public MessageBullet(Bullet BULLET) {
        setConversation(ConversationType.S_SHARE_BULLETS.name());
        this.BULLET = BULLET;
    }

}
