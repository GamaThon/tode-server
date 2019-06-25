/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.tode.archive.controller.runnable.powers;

import com.team142.tode.archive.controller.GameManager;
import com.team142.tode.archive.model.Game;
import com.team142.tode.archive.model.Player;
import com.team142.tode.archive.model.Repository;
import com.team142.tode.archive.model.Server;
import com.team142.tode.archive.model.mappable.artificial.Bullet;

/**
 * @author just1689
 */
public class Power02RearShoot extends Power {

    private static final long INITIAL_COOLDOWN = 5000;

    public Power02RearShoot(Player player) {
        super(2, player, 0, INITIAL_COOLDOWN, 1, "2");
    }

    @Override
    public void execute() {

        Game game = Repository.GAMES_ON_SERVER.get(getPlayer().getGameId());

        //Change state
        Bullet bullet = getPlayer().createBullet();

        //Send bullet backwards
        bullet.rotateLeft((float) Math.PI);

        //Nerf rear bullets by 50% for now
        bullet.setDamage(bullet.getDamage() / 2 + getLevelLessOne() * (10 / 2));
        bullet.setSpeed(bullet.getSpeed() / 2 + getLevelLessOne() * (Server.BULLET_INCREMENT_SPEED / 2));

        //Communicate
        GameManager.sendBullet(game, bullet);
        game.getSoundManager().sendShoot();

    }

    @Override
    public void nofityLevelChange() {
        setRefreshTime(INITIAL_COOLDOWN / getLevel());
    }

}
