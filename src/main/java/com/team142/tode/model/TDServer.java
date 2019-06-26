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

    public static TDServer instance = TDServer.builder()
            .games(new ConcurrentHashMap<>())
            .build();

    private ConcurrentHashMap<String, TDGame> games;
    private ConcurrentHashMap<String, TDPlayer> players;

}
