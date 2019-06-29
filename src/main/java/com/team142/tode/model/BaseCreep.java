package com.team142.tode.model;

import com.team142.tode.controller.ticker.Ticker;
import com.team142.tode.model.map.MoveableElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Builder
public abstract class BaseCreep extends MoveableElement {

    private String id;
    private String gameId;

    private String owner;

    private int health;
    private int armour;

    private Ticker ticker;

}
