package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.loolkable;

import com.piculi.hotlinemaiami.gameobjects.Enemy;
import com.piculi.hotlinemaiami.gameobjects.Human;
import com.piculi.hotlinemaiami.gameobjects.Player;
import com.piculi.hotlinemaiami.gameobjects.interfaces.Lookable;

public class LookableEnemyNaive implements Lookable {
    private Player player;
    public LookableEnemyNaive(Player player) {
        this.player = player;
    }
    @Override
    public void look(Human human) {
        if (!(human instanceof Enemy)){
            throw new IllegalArgumentException("LookableEnemy can only be used by enemies");
        }
        Enemy enemy = (Enemy) human;
        float dx = player.getX() - enemy.getX();
        float dy = player.getY() - enemy.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        if (distance < enemy.getSightRadius()) {
            enemy.heading = (float) Math.atan2(dy, dx);
            enemy.setSeesPlayer(true);
        } else {
            enemy.heading = enemy.heading + (float) (Math.random() * 0.1 - 0.05);
            enemy.setSeesPlayer(false);
        }

    }
}
