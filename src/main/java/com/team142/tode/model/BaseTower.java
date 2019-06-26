package com.team142.tode.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
public class BaseTower extends PlaceableElement {

    private String type;
    private String owner;

    private int level;
    private int damage;
    private long interval;

}
