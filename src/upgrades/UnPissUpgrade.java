package edu.stuy.starlorn.upgrades;

import edu.stuy.starlorn.sound.AudioPlayer;

public class UnPissUpgrade extends GunUpgrade {

    public UnPissUpgrade() {
        super();
        _name = "Dehydrated";
        _description = "You can't piss as much";
	try {
		_voiceLine = new AudioPlayer("/voice/dehydrated.wav", false);
	}catch (Exception e){
		System.out.println("Problem with upgrade voiceline.");
		System.out.println(e.getMessage());
		System.exit(0);
	}
    }

    @Override
    public int getNumShots() {
        return 1;
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
    public String getSpriteName() {
        return "upgrade/dualshot";
    }

    @Override
    public Upgrade clone() {
        return new UnPissUpgrade();
    }
}
