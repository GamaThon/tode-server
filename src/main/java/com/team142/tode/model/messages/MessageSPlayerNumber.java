package com.team142.tode.model.messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MessageSPlayerNumber extends BaseMessage {
    private int PlayerNumber;
}
