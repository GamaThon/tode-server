package com.team142.tode.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.ConcurrentHashMap;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TDServer {

    private static TDServer instance = TDServer.builder()
            .game(new ConcurrentHashMap<>())
            .build();

    public ConcurrentHashMap<String, TDGame> game;
    public ConcurrentHashMap<String, TDPlayer> players;

}
