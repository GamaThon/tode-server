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
public class Server {

    public static Server instance = Server.builder()
            .games(new ConcurrentHashMap<>())
            .players(new ConcurrentHashMap<>())
            .build();

    private ConcurrentHashMap<String, Game> games;
    private ConcurrentHashMap<String, Player> players;


}
