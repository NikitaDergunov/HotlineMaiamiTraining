package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable.projectile;

public enum ProjectileType {
    PISTOL_BULLET("Pistol"),
    AK47_BULLET("Ak47"),

    SHOTGUN_BULLET("Shotgun"),
    RAILGUN_BULLET("Railgun"),
    ROCKET("Rpg");
    private String gunName;

    ProjectileType(String gunName) {
        this.gunName = gunName;
    }
    public String getGunName() {
        return gunName;
    }
    public static ProjectileType getRandomWithoutRailOrRocket(){
        int random = (int) (Math.random() * 3);
        switch (random){
            case 0:
                return PISTOL_BULLET;
            case 1:
                return AK47_BULLET;
            case 2:
                return SHOTGUN_BULLET;
            default:
                return null;
        }

    }
}
