package com.team142.tode.model.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageSPlayerNumber extends BaseMessage {
    private int PlayerNumber;
}
