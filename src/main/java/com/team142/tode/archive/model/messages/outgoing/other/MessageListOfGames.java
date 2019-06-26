/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.archive.model.messages.outgoing.other;

import com.team142.tode.archive.model.Game;
import com.team142.tode.model.messages.ConversationType;
import com.team142.tode.model.messages.BaseMessage;
import lombok.Getter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**

 */
public class MessageListOfGames extends BaseMessage {

    @Getter
    private final List<MessageGameSummary> GAMES;

    public MessageListOfGames(Collection<Game> list) {
        this.GAMES = list
                .stream()
                .map((game) -> game.toGameSummary())
                .collect(Collectors.toList());
        setConversation(ConversationType.S_LIST_OF_GAMES.name());

    }

}
