package com.team142.tode.model;


import com.team142.tode.controller.ticker.Ticker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public abstract class BaseTower extends PlaceableElement {

    private String id;
    private String gameId;

    private String type;
    private String owner;

    private int level;
    private int damage;


    private Ticker ticker;

}
