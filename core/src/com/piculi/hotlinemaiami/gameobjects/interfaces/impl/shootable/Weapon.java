package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.piculi.hotlinemaiami.gameobjects.Human;
import com.piculi.hotlinemaiami.gameobjects.environment.Room;
import com.piculi.hotlinemaiami.gameobjects.interfaces.Shootable;
import com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable.projectile.Projectile;
import com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable.projectile.ProjectileFactory;
import com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable.projectile.ProjectileType;

import java.util.ArrayList;
import java.util.List;

public abstract class Weapon implements Shootable {
    protected float x;
    protected float y;
    protected double heading;
    protected Color color;
    protected int bulletsLeftInMag;
    protected final int magCapacity;
    protected int magCount;
    protected long timeBetweenShots;
    protected long lastShot;
    protected int reloadTime;
    protected long reloadStart;
    protected boolean reloading = false;
    protected int bulletsAtOnce;

    ProjectileType projectileType;
    List<Projectile> firedBullets = new ArrayList<>();
    AmmoDisplay ammoDisplay;

    public Weapon(int x, int y, int bulletsLeftInMag, int magCapacity, int magCount, int reloadTime, long timeBetweenShots, int bulletsAtOnce, ProjectileType projectileType, Color color) {
        this.x = x;
        this.y = y;
        this.bulletsLeftInMag = bulletsLeftInMag;
        this.magCapacity = magCapacity;
        this.magCount = magCount;
        this.reloadTime = reloadTime;
        this.projectileType = projectileType;
        this.color = color;
        this.timeBetweenShots = timeBetweenShots;
        this.lastShot = System.currentTimeMillis();
        this.bulletsAtOnce = bulletsAtOnce;
        this.ammoDisplay = new AmmoDisplay(20,30,bulletsLeftInMag,magCapacity,magCount,projectileType);
    }

    @Override
    public boolean areBulletsColiding(Human human) {
        return false;
    }

    @Override
    public boolean areBulletsColiding(List<Room> rooms) {
        return false;
    }

    private void reload() {
        if(bulletsLeftInMag == 0 && !reloading){
            reloading = true;
        }
        if(magCount == 0){
            reloading = false;
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
        }

    }

    private void shoot() {
        if(reloading) return;
        bulletsLeftInMag--;
        lastShot = System.currentTimeMillis();
        for(int i = 0; i < bulletsAtOnce; i++){
            Projectile bullet = ProjectileFactory.createProjectile(projectileType,x,y,heading);
            firedBullets.add(bullet);
        }
    }
    public void addMag(){
        magCount++;
    }

    @Override
    public void update(Human owner) {

        heading = owner.heading;
        x = (float) (owner.x + owner.radius * Math.cos(heading));
        y = (float) (owner.y + owner.radius * Math.sin(heading));
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT) && (System.currentTimeMillis() - lastShot > timeBetweenShots && bulletsLeftInMag > 0)){
            shoot();

        }
        if (Gdx.input.isKeyPressed(Input.Keys.R)){
            reloading = true;
        }
        reload();
        firedBullets.forEach(Projectile::update);
        firedBullets.removeIf(Projectile::isDead);
        ammoDisplay.setBulletsLeftInMag(bulletsLeftInMag);
        ammoDisplay.setMagCount(magCount);
        ammoDisplay.setReloading(reloading);
        ammoDisplay.setReloadTimeLeft(reloadTime - (System.currentTimeMillis() - reloadStart));

    }


    public void draw(ShapeRenderer shapeRenderer, SpriteBatch spriteBatch, Camera camera, int height, int width) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.rectLine(x,y, (float) (x+height * Math.cos(heading)),(float) (y+height * Math.sin(heading)),width);
        shapeRenderer.end();
        firedBullets.forEach(bullet -> bullet.draw(shapeRenderer));
        ammoDisplay.draw(spriteBatch,camera);
    }

    public List<Projectile> getFiredBullets() {
        return firedBullets;
    }

    protected static int getRandomIntInRange(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
