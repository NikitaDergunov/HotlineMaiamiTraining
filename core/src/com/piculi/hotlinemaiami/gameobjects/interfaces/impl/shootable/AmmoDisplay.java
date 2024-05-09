package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable.projectile.ProjectileType;

public class AmmoDisplay {
    private float x;
    private float y;
    private int bulletsLeftInMag;
    private final int magCapacity;
    private int magCount;
    private BitmapFont font;
    private Color color;
    private boolean reloading = false;
    private long reloadTimeLeft = 0;
    private ProjectileType pr;
    public AmmoDisplay(float x, float y, int bulletsLeftInMag, int magCapacity, int magCount, ProjectileType projectileType) {
        this.x = x;
        this.y = y;
        this.bulletsLeftInMag = bulletsLeftInMag;
        this.magCapacity = magCapacity;
        this.magCount = magCount;
        font = new BitmapFont();
        color = Color.BLACK;
        pr = projectileType;
    }
    public void setBulletsLeftInMag(int bulletsLeftInMag) {
        this.bulletsLeftInMag = bulletsLeftInMag;
    }
    public void setMagCount(int magCount) {
        this.magCount = magCount;
    }
    public void setReloading(boolean reloading) {
        this.reloading = reloading;
    }
    public void setReloadTimeLeft(long reloadTimeLeft) {
        this.reloadTimeLeft = reloadTimeLeft;
    }

    public void draw(SpriteBatch batch, Camera camera) {
        x = camera.position.x - camera.viewportWidth/2 + 20;
        y = camera.position.y + camera.viewportHeight/2 - 20;
        String text = bulletsLeftInMag + "/" + (bulletsLeftInMag + (magCapacity * magCount) + " (" + magCount + ")");
        if (reloading){
            text = "Reloading... " + reloadTimeLeft/100 + "\n" + text;
        }
        text = text + "\n" + getWeaponName();

        batch.begin();
        font.setColor(color);
        font.draw(batch, text, x, y);
        batch.end();
    }

    private String getWeaponName() {
        switch (pr){
            case  PISTOL_BULLET:
                return "Pistol";
            case SHOTGUN_BULLET:
                return "Shotgun";
            case ROCKET:
                return "Rocket";
            case AK47_BULLET:
                return "AK47";
            default:
                return "Unknown";
        }
    }
}
