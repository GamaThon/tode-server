/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.archive.model.messages.outgoing.stats;

import lombok.AllArgsConstructor;
import lombok.Data;

/**

 */
@Data
@AllArgsConstructor
public class MessageNotifyPushover {

    private String user;
    private String token;
    private String message;

}