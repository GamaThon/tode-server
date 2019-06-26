/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.archive.model.messages.incoming;

import com.team142.tode.archive.controller.ServerManager;
import com.team142.tode.model.messages.BaseMessage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**

 */
@NoArgsConstructor
public class MessageJoinServer extends BaseMessage implements Runnable {

    @Setter
    @Getter
    private String name;

    @Override
    public void run() {
        ServerManager.handle(this);

    }

}
