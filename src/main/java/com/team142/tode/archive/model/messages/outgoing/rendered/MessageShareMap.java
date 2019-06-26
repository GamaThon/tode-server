/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.archive.model.messages.outgoing.rendered;

import com.team142.tode.archive.model.Game;
import com.team142.tode.archive.model.mappable.organic.MapTileElement;
import com.team142.tode.archive.model.messages.base.ConversationType;
import com.team142.tode.archive.model.messages.base.Message;
import lombok.Getter;

import java.util.Collection;

/**

 */
public class MessageShareMap extends Message {

    @Getter
    private Collection<MapTileElement> map;
    private int x;
    private int z;

    public MessageShareMap(Game game) {
        setConversation(ConversationType.S_SHARE_MAP.name());
        this.map = game.getMap().getTILES().values();
        this.x = game.getMap().getMaxX();
        this.z = game.getMap().getMaxZ();

    }

}
