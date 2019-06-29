package com.team142.tode.model;

import com.team142.tode.controller.ticker.Ticker;
import com.team142.tode.model.map.MoveableElement;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public abstract class BaseCreep extends MoveableElement {

    private String id;
    private String gameId;

    private String owner;

    private double cost;

    private int health;
    private int armour;

    private Ticker ticker;

}
