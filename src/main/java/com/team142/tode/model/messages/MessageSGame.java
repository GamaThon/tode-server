package com.team142.tode.model.messages;

import com.team142.tode.model.TDGame;
import lombok.Getter;
import java.util.ArrayList;

public class MessageSGame extends BaseMessage {

    @Getter
    private ArrayList<TDGame> games;

    public MessageSGame(ArrayList<TDGame> games) {
        this.setConversationType(ConversationType.S_GAMES);
        this.games = games;
    }

}
