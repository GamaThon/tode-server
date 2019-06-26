/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.archive.model.messages.incoming;

import com.team142.tode.archive.controller.GameManager;
import com.team142.tode.model.messages.BaseMessage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**

 */
@NoArgsConstructor
public class MessageJoinGame extends BaseMessage implements Runnable {

    @Getter
    @Setter
    private String id;

    @Override
    public void run() {
        GameManager.handle(this);

    }

}
