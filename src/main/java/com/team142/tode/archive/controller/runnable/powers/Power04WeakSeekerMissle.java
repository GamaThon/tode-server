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
import com.team142.tode.utils.PhysicsUtils;

import java.util.concurrent.ThreadLocalRandom;

/**

 */
public class Power04WeakSeekerMissle extends Power {

    private static final long INITIAL_COOLDOWN = 5000;

    public Power04WeakSeekerMissle(Player player) {
        super(4, player, 0, INITIAL_COOLDOWN, 1, "4");
    }

    @Override
    public void execute() {
        playerShoots();

    }

    public void playerShoots() {
        Game game = Repository.GAMES_ON_SERVER.get(getPlayer().getGameId());

        //Change state
        Bullet bullet = getPlayer().createBullet();

        bullet.setDamage(100 + getLevelLessOne() * 10);
        bullet.setSpeed(bullet.getSpeed() * 2 + getLevelLessOne() * Server.BULLET_INCREMENT_SPEED);

        int which = ThreadLocalRandom.current().nextInt(0, game.getPlayers().size());

        boolean found = false;
        int triesLeft = 10;
        while (!found && triesLeft > 0) {
            Player playerToTarget = game.getPlayers().get(which);
            if (getPlayer().getId().equals(playerToTarget.getId())) {
                triesLeft--;
                continue;
            }
            float radians = PhysicsUtils.getRadians(getPlayer().getTANK().getPoint(), playerToTarget.getTANK().getPoint());
            bullet.getPoint().setRotation(radians);
            found = true;
        }

        GameManager.sendBullet(game, bullet);
        game.getSoundManager().sendShoot();

    }

    @Override
    public void nofityLevelChange() {
        //Not sure
    }

}
