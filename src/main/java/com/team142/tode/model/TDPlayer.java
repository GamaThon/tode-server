package com.team142.tode.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.socket.WebSocketSession;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TDPlayer {

    private String id;
    private String name;
    private WebSocketSession session;

}
