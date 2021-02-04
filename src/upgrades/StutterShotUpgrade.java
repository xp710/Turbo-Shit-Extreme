package edu.stuy.starlorn.upgrades;

import edu.stuy.starlorn.sound.AudioPlayer;

public class StutterShotUpgrade extends GunUpgrade {
    protected boolean _fast_shot;

    public StutterShotUpgrade() {
        super();
        _name = "Kidney Stones";
        _description = "It's hard to pee constantly!";
        _fast_shot = false;
	try {
		_voiceLine = new AudioPlayer("/voice/kidneystones.wav", false);
	}catch (Exception e){
		System.out.println("Problem with upgrade voiceline.");
		System.out.println(e.getMessage());
		System.exit(0);
	}
    }

    @Override
    public double getShotSpeed(double shotspeed) {
        return shotspeed;
    }

    @Override
    public double getCooldown(double cooldown) {
        _fast_shot = !_fast_shot;
        if (_fast_shot) {
            return cooldown * 3 / 2;
        } else {
            return cooldown / 2;
        }
    }

    @Override
    public String getSpriteName() {
        return "upgrade/stuttershot";
    }

    @Override
    public Upgrade clone() {
        return new StutterShotUpgrade();
    }
}

