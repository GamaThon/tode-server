package com.team142.tode.model.messages;

import com.team142.tode.model.TDGame;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;

public class MessageSGame extends BaseMessage {

    @Getter
    private ArrayList<TDGame> games;

    public MessageSGame(Collection<TDGame> games) {
        this.setConversationType(ConversationType.S_GAMES);
        this.games = new ArrayList<>();
        this.games.addAll(games);

    }

}
