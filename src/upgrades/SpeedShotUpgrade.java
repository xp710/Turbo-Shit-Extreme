package edu.stuy.starlorn.upgrades;

import edu.stuy.starlorn.sound.AudioPlayer;

public class SpeedShotUpgrade extends GunUpgrade {
    public SpeedShotUpgrade() {
        super();
        _name = "Turbo Piss";
        _description = "Blow your dick off!";
    }

    @Override
    public double getShotSpeed(double shotspeed) {
        return shotspeed * 2;
    }

    @Override
    public double getCooldown(double cooldown) {
        return cooldown * .9;
    }

    @Override
    public String getSpriteName() {
        return "upgrade/speedshot";
    }

    @Override
    public Upgrade clone() {
        return new SpeedShotUpgrade();
    }
}
