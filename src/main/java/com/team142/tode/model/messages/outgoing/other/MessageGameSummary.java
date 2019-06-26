/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.model.messages.outgoing.other;

import lombok.AllArgsConstructor;
import lombok.Value;

/**

 */
@Value
@AllArgsConstructor
public class MessageGameSummary {

    private String id;
    private String name;
    private int numberPlaying;

}
