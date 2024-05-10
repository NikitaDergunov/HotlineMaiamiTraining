package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable.projectile;

public enum ProjectileType {
    PISTOL_BULLET("Pistol"),
    AK47_BULLET("Ak47"),
    ROCKET("Rpg"),
    SHOTGUN_BULLET("Shotgun"),
    RAILGUN_BULLET("Railgun");
    private String gunName;

    ProjectileType(String gunName) {
        this.gunName = gunName;
    }
    public String getGunName() {
        return gunName;
    }
}
