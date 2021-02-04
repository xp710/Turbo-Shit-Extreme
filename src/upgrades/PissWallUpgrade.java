package edu.stuy.starlorn.upgrades;

import edu.stuy.starlorn.sound.AudioPlayer;

public class PissWallUpgrade extends GunUpgrade {
    private int _shotNum;

    public PissWallUpgrade() {
        super();
        _shotNum = -4;
        _name = "Wall of Piss";
        _description = "That's a lot of piss!";
	try {
		_voiceLine = new AudioPlayer("/voice/wallofpiss.wav", false);
	}catch (Exception e){
		System.out.println("Problem with upgrade voiceline.");
		System.out.println(e.getMessage());
		System.exit(0);
	}
    }

    @Override
    public int getNumShots() {
        return 9;
    }

    @Override
    public double getShotSpeed(double shotspeed){
        return shotspeed / 5;
    }
    
    @Override
    public double getCooldown(double cooldown){
        return cooldown * 5;
    }

    @Override
    public double getXOffset() {
        int direction = _shotNum;
	_shotNum++;
	if (_shotNum > 4) _shotNum = -4;
        return direction * 50;
    }

    @Override
    public String getSpriteName() {
        return "upgrade/dualshot";
    }

    @Override
    public Upgrade clone() {
        return new PissWallUpgrade();
    }
}
