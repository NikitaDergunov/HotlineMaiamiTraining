package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.walkable;

import com.piculi.hotlinemaiami.gameobjects.Enemy;
import com.piculi.hotlinemaiami.gameobjects.Human;
import com.piculi.hotlinemaiami.gameobjects.Player;
import com.piculi.hotlinemaiami.gameobjects.interfaces.Walkable;

public class WalkableEnemyNaive implements Walkable {
    private Player player;
    public WalkableEnemyNaive(Player player) {
        this.player = player;
    }
    @Override
    public void walk(Human human) {
        if (!(human instanceof Enemy)){
            throw new IllegalArgumentException("WalkableEnemy can only be used by enemies");
        }
        Enemy enemy = (Enemy) human;
        if (!enemy.isSeesPlayer()){
            enemy.setX(enemy.getX() + (float) Math.cos(enemy.heading) * enemy.getSpeed());
            enemy.setY(enemy.getY() + (float) Math.sin(enemy.heading) * enemy.getSpeed());
        }


    }
}
