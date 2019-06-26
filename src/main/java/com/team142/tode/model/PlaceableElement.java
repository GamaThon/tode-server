/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.model;

import lombok.*;

/**
 * @author just1689
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlaceableElement {

    private int tag;
    private SpaceTimePoint point;
    private String skin;
    private String model;

}
