package com.team142.tode.model.messages;

import com.team142.tode.model.Game;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;

public class MessageSGames extends BaseMessage {

    @Getter
    private ArrayList<Game> games;

    public MessageSGames(Collection<Game> games) {
        this.setConversationType(ConversationType.S_GAMES);
        this.games = new ArrayList<>();
        this.games.addAll(games);

    }

}
