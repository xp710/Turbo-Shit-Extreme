package edu.stuy.starlorn.upgrades;

import edu.stuy.starlorn.sound.AudioPlayer;

public class LaserPissUpgrade extends GunUpgrade {

    int _shotNum = -1;

    public LaserPissUpgrade() {
        super();
        _name = "Super Laser Piss!";
        _description = "How do you like that, Obama?!";
	try {
		_voiceLine = new AudioPlayer("/voice/superlaserpiss.wav", false);
	}catch (Exception e){
		System.out.println("Problem with upgrade voiceline.");
		System.out.println(e.getMessage());
		System.exit(0);
	}
    }

    @Override
    public int getNumShots() {
        return 3;
    }

    @Override
    public double getShotSpeed(double shotspeed){
        return shotspeed * 2;
    }
    
    @Override
    public double getCooldown(double cooldown){
        return cooldown/3;
    }

    @Override
    public double getXOffset() {
        int direction = _shotNum;
	_shotNum++;
	if (_shotNum > 1) _shotNum = -1;
        return direction * 5;
    }

    @Override
    public String getSpriteName() {
        return "upgrade/dualshot";
    }

    @Override
    public Upgrade clone() {
        return new LaserPissUpgrade();
    }
}
