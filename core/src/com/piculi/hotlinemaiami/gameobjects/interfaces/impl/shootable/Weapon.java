package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.piculi.hotlinemaiami.gameobjects.Human;
import com.piculi.hotlinemaiami.gameobjects.Room;
import com.piculi.hotlinemaiami.gameobjects.interfaces.Shootable;
import com.piculi.hotlinemaiami.gameobjects.projectile.Projectile;
import com.piculi.hotlinemaiami.gameobjects.projectile.ProjectileType;

import java.util.ArrayList;
import java.util.List;

public abstract class Weapon implements Shootable {
    float x;
    float y;
    double heading;
    Color color;
    int bulletsLeftInMag;
    int magCapacity;
    int magCount;
    int reloadTime;
    long reloadStart;
    boolean reloading = false;

    ProjectileType projectileType;
    List<Projectile> firedBullets = new ArrayList<>();

    public Weapon(int x, int y, int bulletsLeftInMag, int magCapacity, int magCount, int reloadTime, ProjectileType projectileType, Color color) {
        this.x = x;
        this.y = y;
        this.bulletsLeftInMag = bulletsLeftInMag;
        this.magCapacity = magCapacity;
        this.magCount = magCount;
        this.reloadTime = reloadTime;
        this.projectileType = projectileType;
        this.color = color;
    }

    @Override
    public boolean areBulletsColiding(Human human) {
        return false;
    }

    @Override
    public boolean areBulletsColiding(List<Room> rooms) {
        return false;
    }

    @Override
    public void reload() {
        if(magCount == 0){
            return;
        }
        if (reloading) {
            if (System.currentTimeMillis() - reloadStart > reloadTime) {
                bulletsLeftInMag = magCapacity;
                magCount--;
                reloading = false;
            }
        }else {
            reloadStart = System.currentTimeMillis();
            reloading = true;
        }

    }

    @Override
    public void shoot() {

    }
    public void addMag(){
        magCount++;
    }

    @Override
    public void update(Human owner) {
        heading = owner.heading;
        x = (float) (owner.x + owner.radius * Math.cos(heading));
        y = (float) (owner.y + owner.radius * Math.sin(heading));

    }

    protected static int getRandomIntInRange(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
